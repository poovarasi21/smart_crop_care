package com.smartcropcare.app.ui.dialogs

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.smartcropcare.app.R
import com.smartcropcare.app.databinding.DialogLogPestBinding

class LogPestDialog(
    private val onLogPest: (name: String, symptoms: String, management: String, treatment: String) -> Unit
) : DialogFragment() {

    private var _binding: DialogLogPestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogLogPestBinding.inflate(LayoutInflater.from(requireContext()))

        return AlertDialog.Builder(requireContext())
            .setTitle("Log Pest Incident")
            .setView(binding.root)
            .setPositiveButton(getString(R.string.action_save)) { _, _ ->
                val name = binding.etPestName.text.toString().trim()
                val symptoms = binding.etPestSymptoms.text.toString().trim()
                val management = binding.etPestManagement.text.toString().trim()
                val treatment = binding.etPestTreatment.text.toString().trim()

                if (name.isNotEmpty()) {
                    onLogPest(name, symptoms, management, treatment)
                }
            }
            .setNegativeButton(getString(R.string.action_cancel), null)
            .create()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "LogPestDialog"
    }
}
