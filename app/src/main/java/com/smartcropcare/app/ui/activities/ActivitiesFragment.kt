package com.smartcropcare.app.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartcropcare.app.SmartCropCareApp
import com.smartcropcare.app.databinding.FragmentActivitiesBinding
import com.smartcropcare.app.ui.home.HomeViewModel
import com.smartcropcare.app.utils.SessionManager
import kotlinx.coroutines.launch

class ActivitiesFragment : Fragment() {

    private var _binding: FragmentActivitiesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels {
        val app = requireActivity().application as SmartCropCareApp
        val sessionManager = SessionManager(requireContext())
        HomeViewModel.Factory(app.container.cropRepository, app.container.weatherRepository, sessionManager.getUserId())
    }

    private lateinit var adapter: FarmActivityAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActivitiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FarmActivityAdapter { activity, isCompleted ->
            viewModel.toggleActivity(activity.id, isCompleted)
        }
        binding.rvActivitiesList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvActivitiesList.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.activities.collect { activities ->
                adapter.submitList(activities)
                val completed = activities.count { it.isCompleted }
                binding.tvActivitySummary.text = "$completed of ${activities.size} Tasks Completed Today"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
