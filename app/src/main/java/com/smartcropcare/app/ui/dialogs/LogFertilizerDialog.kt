package com.smartcropcare.app.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.smartcropcare.app.databinding.DialogLogFertilizerBinding

class LogFertilizerDialog(
    private val onFertilizerLogged: (nutrient: String, dosage: String, method: String) -> Unit
) : BottomSheetDialogFragment() {

    private var _binding: DialogLogFertilizerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogLogFertilizerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmitFertilizerLog.setOnClickListener {
            val nutrient = binding.etNutrientName.text?.toString()?.trim() ?: "Boron & Calcium"
            val dosage = binding.etDosage.text?.toString()?.trim() ?: "2g / Litre"
            val method = binding.etFertilizerMethod.text?.toString()?.trim() ?: "Fertigation"

            onFertilizerLogged(nutrient, dosage, method)
            Toast.makeText(requireContext(), "Fertilizer dose saved!", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "LogFertilizerDialog"
    }
}
