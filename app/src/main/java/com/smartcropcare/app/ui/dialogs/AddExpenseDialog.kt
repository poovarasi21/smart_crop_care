package com.smartcropcare.app.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.smartcropcare.app.databinding.DialogAddExpenseBinding

class AddExpenseDialog(
    private val onExpenseAdded: (category: String, amount: Double, desc: String) -> Unit
) : BottomSheetDialogFragment() {

    private var _binding: DialogAddExpenseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogAddExpenseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmitExpense.setOnClickListener {
            val category = binding.etExpenseCategory.text?.toString()?.trim() ?: "Fertilizer"
            val amount = binding.etExpenseAmount.text?.toString()?.toDoubleOrNull() ?: 1500.0
            val desc = binding.etExpenseDesc.text?.toString()?.trim() ?: ""

            onExpenseAdded(category, amount, desc)
            Toast.makeText(requireContext(), "Expense of ₹$amount recorded!", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "AddExpenseDialog"
    }
}
