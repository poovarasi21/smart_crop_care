package com.smartcropcare.app.ui.location

import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.smartcropcare.app.R
import com.smartcropcare.app.data.model.LocationData
import com.smartcropcare.app.databinding.DialogLocationSelectBinding
import com.smartcropcare.app.utils.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale

class LocationSelectDialog(
    private val onLocationSelected: (LocationData?) -> Unit
) : BottomSheetDialogFragment() {

    private var _binding: DialogLocationSelectBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogLocationSelectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sessionManager = SessionManager(requireContext())

        // Use Current Device Location
        binding.btnUseCurrentLocation.setOnClickListener {
            sessionManager.setLocationModeToCurrent()
            onLocationSelected(null)
            dismiss()
        }

        // Search Button
        binding.btnSearch.setOnClickListener {
            performLocationSearch()
        }

        binding.etSearchQuery.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                performLocationSearch()
                true
            } else false
        }

        // Quick Select Chips
        binding.chipSalem.setOnClickListener { searchAndSelect("Salem, Tamil Nadu, India") }
        binding.chipChennai.setOnClickListener { searchAndSelect("Chennai, Tamil Nadu, India") }
        binding.chipCoimbatore.setOnClickListener { searchAndSelect("Coimbatore, Tamil Nadu, India") }
        binding.chipMadurai.setOnClickListener { searchAndSelect("Madurai, Tamil Nadu, India") }
        binding.chipBengaluru.setOnClickListener { searchAndSelect("Bengaluru, Karnataka, India") }
    }

    private fun performLocationSearch() {
        val query = binding.etSearchQuery.text.toString().trim()
        if (query.isEmpty()) {
            Toast.makeText(requireContext(), "Please enter a location name", Toast.LENGTH_SHORT).show()
            return
        }
        searchAndSelect(query)
    }

    private fun searchAndSelect(query: String) {
        binding.pbLocationSearch.visibility = View.VISIBLE
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val geocoder = Geocoder(requireContext(), Locale.getDefault())
                @Suppress("DEPRECATION")
                val addresses = geocoder.getFromLocationName(query, 1)

                withContext(Dispatchers.Main) {
                    binding.pbLocationSearch.visibility = View.GONE
                    if (addresses != null && addresses.isNotEmpty()) {
                        val addr = addresses[0]
                        val city = addr.locality ?: addr.subAdminArea ?: addr.adminArea ?: query
                        val state = addr.adminArea ?: ""
                        val country = addr.countryName ?: ""

                        val location = LocationData(
                            latitude = addr.latitude,
                            longitude = addr.longitude,
                            city = city,
                            state = state,
                            country = country,
                            isCurrentLocation = false
                        )

                        SessionManager(requireContext()).saveLocation(location)
                        onLocationSelected(location)
                        dismiss()
                    } else {
                        Toast.makeText(requireContext(), getString(R.string.loc_not_found), Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    binding.pbLocationSearch.visibility = View.GONE
                    Toast.makeText(requireContext(), "Error searching location: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "LocationSelectDialog"
    }
}
