package com.smartcropcare.app.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import com.smartcropcare.app.SmartCropCareApp
import com.smartcropcare.app.databinding.FragmentProfileBinding
import com.smartcropcare.app.ui.auth.LoginActivity
import com.smartcropcare.app.utils.LocaleHelper
import com.smartcropcare.app.utils.SessionManager
import com.smartcropcare.app.R

import androidx.activity.result.contract.ActivityResultContracts
import android.net.Uri
import android.provider.MediaStore
import android.graphics.Bitmap
import com.smartcropcare.app.ui.main.MainActivity
import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.location.Geocoder
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.google.android.gms.location.LocationServices
import java.io.File
import java.io.FileOutputStream
import java.util.Locale

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val pickImageLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            try {
                val inputStream = requireContext().contentResolver.openInputStream(it)
                val file = File(requireContext().filesDir, "profile_${System.currentTimeMillis()}.jpg")
                val outputStream = FileOutputStream(file)
                inputStream?.copyTo(outputStream)
                inputStream?.close()
                outputStream.close()

                val localUri = Uri.fromFile(file)
                binding.ivFarmerProfile.setImageURI(localUri)
                saveProfilePhoto(localUri.toString())
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(requireContext(), "Failed to save photo", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val takePhotoLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val bitmap = result.data?.extras?.get("data") as? Bitmap
            bitmap?.let {
                try {
                    val file = File(requireContext().filesDir, "profile_${System.currentTimeMillis()}.jpg")
                    val outputStream = FileOutputStream(file)
                    it.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
                    outputStream.close()

                    val localUri = Uri.fromFile(file)
                    binding.ivFarmerProfile.setImageURI(localUri)
                    saveProfilePhoto(localUri.toString())
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(requireContext(), "Failed to save photo", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnToggleLang.setOnClickListener {
            val current = LocaleHelper.getLanguage(requireContext())
            val target = if (current == "en") "ta" else "en"
            LocaleHelper.setLocale(requireContext(), target)
            Toast.makeText(requireContext(), getString(R.string.language_switched, target), Toast.LENGTH_SHORT).show()
        }

        binding.btnLogout.setOnClickListener {
            val sessionManager = SessionManager(requireContext())
            sessionManager.logout()
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        binding.btnChangePhoto.setOnClickListener {
            val options = arrayOf("Take Photo with Camera", "Choose from Gallery")
            AlertDialog.Builder(requireContext())
                .setTitle("Update Profile Photo")
                .setItems(options) { _, which ->
                    if (which == 0) {
                        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                            takePhotoLauncher.launch(intent)
                        } else {
                            requestPermissions(arrayOf(Manifest.permission.CAMERA), 2001)
                        }
                    } else {
                        pickImageLauncher.launch("image/*")
                    }
                }
                .show()
        }

        val sessionManager = SessionManager(requireContext())
        val userId = sessionManager.getUserId()
        val app = requireActivity().application as SmartCropCareApp
        viewLifecycleOwner.lifecycleScope.launch {
            val user = app.container.database.userDao().getUserById(userId)
            if (user != null) {
                binding.tvFarmerName.text = user.name
                if (user.profilePhotoUri != null) {
                    try {
                        binding.ivFarmerProfile.setImageURI(Uri.parse(user.profilePhotoUri))
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
        
        binding.btnEditName.setOnClickListener {
            val editText = EditText(requireContext())
            editText.setText(binding.tvFarmerName.text)
            AlertDialog.Builder(requireContext())
                .setTitle(getString(R.string.edit_profile_name))
                .setView(editText)
                .setPositiveButton(getString(R.string.action_save)) { _, _ ->
                    val newName = editText.text.toString().trim()
                    if (newName.isNotEmpty()) {
                        binding.tvFarmerName.text = newName
                        viewLifecycleOwner.lifecycleScope.launch {
                            val userDao = app.container.database.userDao()
                            val user = userDao.getUserById(userId)
                            if (user != null) {
                                userDao.updateUser(user.copy(name = newName))
                            }
                        }
                    }
                }
                .setNegativeButton(getString(R.string.action_cancel), null)
                .show()
        }
        
        fetchLocationForProfile()
    }

    private fun fetchLocationForProfile() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            val fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                location?.let {
                    try {
                        val geocoder = Geocoder(requireContext(), Locale.getDefault())
                        val addresses = geocoder.getFromLocation(it.latitude, it.longitude, 1)
                        if (addresses != null && addresses.isNotEmpty()) {
                            val address = addresses[0]
                            val city = address.locality ?: address.subAdminArea ?: address.adminArea
                            val state = address.adminArea
                            binding.tvFarmerLocation.text = getString(R.string.city_state_format, city, state)
                        }
                    } catch (e: Exception) {
                        binding.tvFarmerLocation.text = "${it.latitude.toString().take(6)}, ${it.longitude.toString().take(6)}"
                    }
                }
            }
        }
    }

    private fun saveProfilePhoto(uriString: String) {
        val sessionManager = SessionManager(requireContext())
        val userId = sessionManager.getUserId()
        val app = requireActivity().application as SmartCropCareApp
        viewLifecycleOwner.lifecycleScope.launch {
            val userDao = app.container.database.userDao()
            val user = userDao.getUserById(userId)
            if (user != null) {
                val updatedUser = user.copy(profilePhotoUri = uriString)
                userDao.updateUser(updatedUser)
                Toast.makeText(requireContext(), getString(R.string.profile_updated), Toast.LENGTH_SHORT).show()
                (requireActivity() as? MainActivity)?.recreate() // Reload to update toolbar avatar
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
