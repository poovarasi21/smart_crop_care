package com.smartcropcare.app.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.smartcropcare.app.databinding.ActivitySplashBinding
import com.smartcropcare.app.ui.auth.LoginActivity
import com.smartcropcare.app.ui.main.MainActivity
import com.smartcropcare.app.utils.LocaleHelper
import com.smartcropcare.app.utils.SessionManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupLanguageSwitcher()
        runInitializationProgression()

        binding.root.setOnClickListener {
            proceedToDashboard()
        }
    }

    private fun setupLanguageSwitcher() {
        binding.tvLangEnglish.setOnClickListener {
            LocaleHelper.setLocale(this, "en")
        }
        binding.tvLangTamil.setOnClickListener {
            LocaleHelper.setLocale(this, "ta")
        }
    }

    private fun runInitializationProgression() {
        val stages = listOf(
            Pair(24, "Calibrating Soil Moisture Telemetry..."),
            Pair(52, "Syncing Crop Phenology Database..."),
            Pair(78, "Initializing Agronomic AI Engine..."),
            Pair(95, "Verifying Field Mesh Gateway..."),
            Pair(100, "Precision Dashboard Ready")
        )

        lifecycleScope.launch {
            for (stage in stages) {
                binding.splashProgressBar.progress = stage.first
                binding.tvInitPercentage.text = "${stage.first}%"
                binding.tvInitStatus.text = stage.second
                delay(600)
            }
            delay(400)
            proceedToDashboard()
        }
    }

    private fun proceedToDashboard() {
        val sessionManager = SessionManager(this)
        if (sessionManager.isLoggedIn()) {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        finish()
    }
}
