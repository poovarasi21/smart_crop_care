package com.smartcropcare.app.ui.dialogs

import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.smartcropcare.app.R
import com.smartcropcare.app.databinding.DialogLogHarvestBinding

class LogHarvestDialog(
    private val onLogHarvest: (quantity: Double, unit: String, sellingPrice: Double, notes: String) -> Unit
) : DialogFragment() {

    private var _binding: DialogLogHarvestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogLogHarvestBinding.inflate(LayoutInflater.from(requireContext()))

        val units = arrayOf("Kg", "Quintal", "Ton", "Bags (50kg)", "Crates (25kg)")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, units)
        binding.actvHarvestUnit.setAdapter(adapter)
        binding.actvHarvestUnit.setText(units[0], false)

        val watcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                calculateRevenue()
            }
            override fun afterTextChanged(s: Editable?) {}
        }
        binding.etHarvestQty.addTextChangedListener(watcher)
        binding.etHarvestPrice.addTextChangedListener(watcher)

        return AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.harvest_title))
            .setView(binding.root)
            .setPositiveButton(getString(R.string.action_save)) { _, _ ->
                val qty = binding.etHarvestQty.text.toString().toDoubleOrNull() ?: 0.0
                val unit = binding.actvHarvestUnit.text.toString()
                val price = binding.etHarvestPrice.text.toString().toDoubleOrNull() ?: 0.0
                val notes = binding.etHarvestNotes.text.toString().trim()
                if (qty > 0 && price > 0) {
                    onLogHarvest(qty, unit, price, notes)
                }
            }
            .setNegativeButton(getString(R.string.action_cancel), null)
            .create()
    }

    private fun calculateRevenue() {
        val qty = binding.etHarvestQty.text.toString().toDoubleOrNull() ?: 0.0
        val price = binding.etHarvestPrice.text.toString().toDoubleOrNull() ?: 0.0
        val revenue = qty * price
        binding.tvCalculatedRevenue.text = getString(R.string.revenue_calc, String.format("%.2f", revenue))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "LogHarvestDialog"
    }
}
