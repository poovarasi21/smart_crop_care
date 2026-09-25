package com.smartcropcare.app.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.smartcropcare.app.databinding.DialogLogWaterBinding

class LogWaterDialog(
    private val onWaterLogged: (liters: Int, duration: Int, method: String) -> Unit
) : BottomSheetDialogFragment() {

    private var _binding: DialogLogWaterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogLogWaterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmitWaterLog.setOnClickListener {
            val liters = binding.etLitersApplied.text?.toString()?.toIntOrNull() ?: 400
            val duration = binding.etDurationMinutes.text?.toString()?.toIntOrNull() ?: 45
            val method = binding.etIrrigationMethod.text?.toString()?.trim() ?: "Drip #2"

            onWaterLogged(liters, duration, method)
            Toast.makeText(requireContext(), "Irrigation of $liters L logged successfully!", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "LogWaterDialog"
    }
}
