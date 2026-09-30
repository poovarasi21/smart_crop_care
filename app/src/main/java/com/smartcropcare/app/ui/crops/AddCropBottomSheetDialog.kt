package com.smartcropcare.app.ui.crops

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.smartcropcare.app.data.local.entity.CropEntity
import com.smartcropcare.app.databinding.DialogAddCropBinding

class AddCropBottomSheetDialog(
    private val onCropCreated: (CropEntity) -> Unit
) : BottomSheetDialogFragment() {

    private var _binding: DialogAddCropBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogAddCropBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSaveCrop.setOnClickListener {
            val name = binding.etCropName.text?.toString()?.trim() ?: ""
            val rawVariety = binding.etCropVariety.text?.toString()?.trim() ?: ""
            val variety = if (rawVariety.isNotEmpty()) rawVariety else "$name F1 Hybrid"
            val plot = binding.etPlotName.text?.toString()?.trim() ?: "Plot D"
            val acreage = binding.etAcreage.text?.toString()?.toDoubleOrNull() ?: 1.0
            val soil = binding.etSoilType.text?.toString()?.trim() ?: "Red Sandy Loam Soil"

            if (name.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter Crop name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newCrop = CropEntity(
                name = name,
                variety = variety,
                scientificName = "$name sp.",
                hybridType = "F1 Hybrid Variety",
                plotName = "$plot - Active Acre",
                zoneBed = "Zone West-1 • Bed 01",
                acreage = acreage,
                soilType = soil,
                plantingDate = "Today",
                cropAgeDays = 1,
                currentStageIndex = 0, // Seed
                stageName = "Seed Stage",
                stageCompletionPct = 10,
                healthScore = 95,
                healthStatus = "Optimal",
                cycleProgressPct = 5,
                waterStatus = "Initial Irrigation Done",
                fertilizerStatus = "Basal dose applied",
                harvestCountdownDays = 90,
                imageResName = "tomato_plant",
                certificateId = "SCC-TN-2026-REG${System.currentTimeMillis() % 1000}",
                estimatedYieldTonPerAcre = 14.0,
                totalInvestment = 5000.0,
                projectedRevenue = 25000.0,
                soilMoisturePct = 68
            )

            onCropCreated(newCrop)
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "AddCropBottomSheetDialog"
    }
}
