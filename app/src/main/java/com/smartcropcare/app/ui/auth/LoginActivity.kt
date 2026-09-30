package com.smartcropcare.app.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.smartcropcare.app.R
import com.smartcropcare.app.SmartCropCareApp
import com.smartcropcare.app.databinding.ActivityLoginBinding
import com.smartcropcare.app.ui.main.MainActivity
import com.smartcropcare.app.utils.SessionManager
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sessionManager: SessionManager

    private val viewModel: AuthViewModel by viewModels {
        val app = application as SmartCropCareApp
        AuthViewModel.Factory(app.container.authRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        sessionManager = SessionManager(this)

        lifecycleScope.launch {
            viewModel.isLoading.collect { loading ->
                binding.btnLogin.isEnabled = !loading
                binding.btnLogin.text = if (loading) getString(R.string.loading) else getString(R.string.login_button)
            }
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, getString(R.string.error_fill_all_fields), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.login(email, password) { result ->
                result.fold(
                    onSuccess = { user ->
                        sessionManager.saveUserId(user.id)
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    },
                    onFailure = { error ->
                        val msg = error.message ?: getString(R.string.login_failed)
                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
