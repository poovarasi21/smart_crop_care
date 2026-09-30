package com.smartcropcare.app.ui.profile

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.location.Geocoder
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.location.LocationServices
import com.smartcropcare.app.R
import com.smartcropcare.app.SmartCropCareApp
import com.smartcropcare.app.databinding.FragmentProfileBinding
import com.smartcropcare.app.ui.auth.LoginActivity
import com.smartcropcare.app.ui.location.LocationSelectDialog
import com.smartcropcare.app.ui.main.MainActivity
import com.smartcropcare.app.utils.LocaleHelper
import com.smartcropcare.app.utils.SessionManager
import kotlinx.coroutines.launch
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

        val sessionManager = SessionManager(requireContext())
        val userId = sessionManager.getUserId()
        val app = requireActivity().application as SmartCropCareApp

        // 1. Language switcher
        binding.btnToggleLang.setOnClickListener {
            val current = LocaleHelper.getLanguage(requireContext())
            val target = if (current == "en") "ta" else "en"
            sessionManager.saveLanguage(target)
            LocaleHelper.setLocale(requireContext(), target)
            Toast.makeText(requireContext(), getString(R.string.language_switched, target), Toast.LENGTH_SHORT).show()
            requireActivity().recreate()
        }

        // 2. Logout
        binding.btnLogout.setOnClickListener {
            sessionManager.logout()
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            requireActivity().finish()
        }

        // 3. Change photo
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

        // 4. Load real user info from database
        viewLifecycleOwner.lifecycleScope.launch {
            val user = app.container.authRepository.getUserById(userId)
            if (user != null) {
                binding.tvFarmerName.text = user.name
                binding.tvFarmerEmail.text = user.email
                binding.tvFarmerPhone.text = if (user.phone.isNotEmpty()) user.phone else "Phone: Not provided"
                if (!user.profilePhotoUri.isNullOrEmpty()) {
                    try {
                        binding.ivFarmerProfile.setImageURI(Uri.parse(user.profilePhotoUri))
                    } catch (e: Exception) {
                        binding.ivFarmerProfile.setImageResource(R.drawable.ic_person)
                    }
                } else {
                    binding.ivFarmerProfile.setImageResource(R.drawable.ic_person)
                }
            }
        }

        // 5. Edit Name & Phone dialog
        binding.btnEditName.setOnClickListener {
            val layout = LinearLayout(requireContext()).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(50, 40, 50, 10)
            }
            val etName = EditText(requireContext()).apply {
                hint = "Full Name"
                setText(binding.tvFarmerName.text)
            }
            val etPhone = EditText(requireContext()).apply {
                hint = "Phone Number"
                val currentPhone = binding.tvFarmerPhone.text.toString().removePrefix("Phone: ")
                if (currentPhone != "Not provided") setText(currentPhone)
            }
            layout.addView(etName)
            layout.addView(etPhone)

            AlertDialog.Builder(requireContext())
                .setTitle(getString(R.string.edit_profile_name))
                .setView(layout)
                .setPositiveButton(getString(R.string.action_save)) { _, _ ->
                    val newName = etName.text.toString().trim()
                    val newPhone = etPhone.text.toString().trim()
                    if (newName.isNotEmpty()) {
                        binding.tvFarmerName.text = newName
                        binding.tvFarmerPhone.text = if (newPhone.isNotEmpty()) newPhone else "Phone: Not provided"
                        viewLifecycleOwner.lifecycleScope.launch {
                            val userDao = app.container.database.userDao()
                            val user = userDao.getUserById(userId)
                            if (user != null) {
                                userDao.updateUser(user.copy(name = newName, phone = newPhone))
                            }
                        }
                    }
                }
                .setNegativeButton(getString(R.string.action_cancel), null)
                .show()
        }

        // 6. Location configuration
        updateLocationDisplay()
        binding.btnChangeLocation.setOnClickListener {
            LocationSelectDialog {
                updateLocationDisplay()
                // Refresh weather in MainActivity if available
                (requireActivity() as? MainActivity)?.let { mainAct ->
                    val loc = sessionManager.getLocation()
                    if (loc != null) {
                        val androidLoc = android.location.Location("manual").apply {
                            latitude = loc.latitude
                            longitude = loc.longitude
                        }
                        viewLifecycleOwner.lifecycleScope.launch {
                            app.container.weatherRepository.refreshWeatherTelemetry(androidLoc, sessionManager.getWeatherApiKey())
                        }
                    }
                }
            }.show(parentFragmentManager, LocationSelectDialog.TAG)
        }

        // 7. Weather API Key configuration
        updateApiKeyDisplay()
        binding.btnConfigureApiKey.setOnClickListener {
            val input = EditText(requireContext()).apply {
                hint = "Paste OpenWeather API Key"
                setText(sessionManager.getWeatherApiKey())
            }
            AlertDialog.Builder(requireContext())
                .setTitle(getString(R.string.weather_api_key_title))
                .setView(input)
                .setPositiveButton(getString(R.string.save_api_key)) { _, _ ->
                    val key = input.text.toString().trim()
                    sessionManager.saveWeatherApiKey(key)
                    updateApiKeyDisplay()
                    Toast.makeText(requireContext(), "API Key saved successfully", Toast.LENGTH_SHORT).show()
                    // Trigger weather refresh
                    val loc = sessionManager.getLocation()
                    if (loc != null) {
                        val androidLoc = android.location.Location("provider").apply {
                            latitude = loc.latitude
                            longitude = loc.longitude
                        }
                        viewLifecycleOwner.lifecycleScope.launch {
                            app.container.weatherRepository.refreshWeatherTelemetry(androidLoc, key)
                        }
                    }
                }
                .setNegativeButton(getString(R.string.action_cancel), null)
                .show()
        }

        // 8. Notifications setting
        binding.switchNotifications.isChecked = sessionManager.isNotificationsEnabled()
        binding.tvNotificationStatus.text = if (binding.switchNotifications.isChecked) {
            getString(R.string.notifications_enabled)
        } else {
            getString(R.string.notifications_disabled)
        }
        binding.switchNotifications.setOnCheckedChangeListener { _, isChecked ->
            sessionManager.saveNotificationsEnabled(isChecked)
            binding.tvNotificationStatus.text = if (isChecked) {
                getString(R.string.notifications_enabled)
            } else {
                getString(R.string.notifications_disabled)
            }
        }
    }

    private fun updateApiKeyDisplay() {
        val sessionManager = SessionManager(requireContext())
        val key = sessionManager.getWeatherApiKey()
        if (key.isNotEmpty()) {
            val masked = if (key.length > 8) "${key.take(4)}...${key.takeLast(4)}" else "Configured"
            binding.tvSettingsApiKeyStatus.text = "Active ($masked)"
        } else {
            binding.tvSettingsApiKeyStatus.text = "Not Configured"
        }
    }

    private fun updateLocationDisplay() {
        val sessionManager = SessionManager(requireContext())
        val loc = sessionManager.getLocation()
        if (loc != null) {
            val modeText = if (loc.isCurrentLocation) "(GPS)" else "(Manual)"
            val displayText = if (loc.city.isNotEmpty()) {
                "${loc.city}, ${loc.state} $modeText"
            } else {
                "${String.format(Locale.ROOT, "%.2f", loc.latitude)}, ${String.format(Locale.ROOT, "%.2f", loc.longitude)} $modeText"
            }
            binding.tvFarmerLocation.text = displayText
            binding.tvSettingsLocation.text = displayText
        } else {
            fetchLocationForProfile()
        }
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
                            val city = address.locality ?: address.subAdminArea ?: address.adminArea ?: "Tamil Nadu"
                            val state = address.adminArea ?: "India"
                            val text = getString(R.string.city_state_format, city, state)
                            binding.tvFarmerLocation.text = text
                            binding.tvSettingsLocation.text = "$text (GPS)"
                        }
                    } catch (e: Exception) {
                        val latLon = "${it.latitude.toString().take(6)}, ${it.longitude.toString().take(6)} (GPS)"
                        binding.tvFarmerLocation.text = latLon
                        binding.tvSettingsLocation.text = latLon
                    }
                }
            }
        } else {
            binding.tvFarmerLocation.text = getString(R.string.location_unavailable)
            binding.tvSettingsLocation.text = getString(R.string.location_unavailable)
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
                (requireActivity() as? MainActivity)?.recreate()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
