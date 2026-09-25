package com.smartcropcare.app.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.smartcropcare.app.R
import com.smartcropcare.app.SmartCropCareApp
import com.smartcropcare.app.databinding.ActivityMainBinding
import com.smartcropcare.app.ui.activities.ActivitiesFragment
import com.smartcropcare.app.ui.crops.CropListFragment
import com.smartcropcare.app.ui.home.HomeFragment
import com.smartcropcare.app.ui.profile.ProfileFragment
import com.smartcropcare.app.utils.LocaleHelper
import com.smartcropcare.app.utils.SessionManager
import kotlinx.coroutines.launch
import android.Manifest
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.Locale
import android.net.Uri
import android.os.Build

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val LOCATION_PERMISSION_REQUEST_CODE = 1001
    private val NOTIFICATION_PERMISSION_REQUEST_CODE = 1002

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        setupTopBarActions()
        setupBottomNavigation()
        fetchLocation()
        loadUserProfile()
        checkNotificationPermission()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.navHostFragment, HomeFragment())
                .commit()
        }
    }

    private fun loadUserProfile() {
        val sessionManager = SessionManager(this)
        val userId = sessionManager.getUserId()
        val app = application as SmartCropCareApp
        lifecycleScope.launch {
            val user = app.container.database.userDao().getUserById(userId)
            if (user != null) {
                if (user.profilePhotoUri != null) {
                    try {
                        binding.ivFarmerAvatar.setImageURI(Uri.parse(user.profilePhotoUri))
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }
    
    private fun checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), NOTIFICATION_PERMISSION_REQUEST_CODE)
            }
        }
    }

    private fun fetchLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }
        
        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            location?.let {
                updateLocationUI(it)
            } ?: run {
                binding.tvLocation.text = "Location unavailable"
            }
        }.addOnFailureListener {
            binding.tvLocation.text = "Location failed"
        }
    }

    private fun updateLocationUI(location: Location) {
        try {
            val geocoder = Geocoder(this, Locale.getDefault())
            val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)
            if (addresses != null && addresses.isNotEmpty()) {
                val address = addresses[0]
                val city = address.locality ?: address.subAdminArea ?: address.adminArea
                val state = address.adminArea
                binding.tvLocation.text = "$city, $state"
            } else {
                binding.tvLocation.text = "Unknown location"
            }
        } catch (e: Exception) {
            binding.tvLocation.text = "${location.latitude.toString().take(6)}, ${location.longitude.toString().take(6)}"
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                fetchLocation()
            } else {
                binding.tvLocation.text = getString(R.string.location_permission_denied)
                Toast.makeText(this, getString(R.string.location_rationale), Toast.LENGTH_LONG).show()
            }
        }
        if (requestCode == NOTIFICATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Notifications enabled
            }
        }
    }

    private fun setupTopBarActions() {
        binding.btnLanguageToggle.setOnClickListener {
            val currentLang = LocaleHelper.getLanguage(this)
            val newLang = if (currentLang == "en") "ta" else "en"
            LocaleHelper.setLocale(this, newLang)
            // No need for recreate() as AppCompatDelegate handles it automatically
        }

        binding.btnNotification.setOnClickListener {
            Toast.makeText(
                this,
                "Advisory: High humidity & rain expected by 3 PM. Postpone foliar spray.",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            val fragment: Fragment = when (item.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_crops -> CropListFragment()
                R.id.nav_activities -> ActivitiesFragment()
                R.id.nav_profile -> ProfileFragment()
                else -> HomeFragment()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.navHostFragment, fragment)
                .commit()
            true
        }
    }
}
