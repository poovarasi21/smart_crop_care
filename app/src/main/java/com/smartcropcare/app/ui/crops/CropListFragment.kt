package com.smartcropcare.app.ui.crops

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartcropcare.app.SmartCropCareApp
import com.smartcropcare.app.databinding.FragmentCropListBinding
import com.smartcropcare.app.ui.home.HomeViewModel
import com.smartcropcare.app.ui.overview.CropOverviewActivity
import com.smartcropcare.app.utils.SessionManager
import kotlinx.coroutines.launch

class CropListFragment : Fragment() {

    private var _binding: FragmentCropListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels {
        val app = requireActivity().application as SmartCropCareApp
        val sessionManager = SessionManager(requireContext())
        HomeViewModel.Factory(app.container.cropRepository, app.container.weatherRepository, sessionManager.getUserId())
    }

    private lateinit var adapter: CropAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCropListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CropAdapter { crop ->
            val intent = Intent(requireContext(), CropOverviewActivity::class.java).apply {
                putExtra("EXTRA_CROP_ID", crop.id)
            }
            startActivity(intent)
        }
        binding.rvAllCrops.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAllCrops.adapter = adapter

        binding.btnAddCropFab.setOnClickListener {
            AddCropBottomSheetDialog { newCrop ->
                val sessionManager = SessionManager(requireContext())
                val cropWithUser = newCrop.copy(userId = sessionManager.getUserId())
                viewModel.addNewCrop(cropWithUser)
            }.show(childFragmentManager, AddCropBottomSheetDialog.TAG)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.activeCrops.collect { crops ->
                adapter.submitList(crops)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
