package com.smartcropcare.app.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartcropcare.app.SmartCropCareApp
import com.smartcropcare.app.databinding.FragmentHomeBinding
import com.smartcropcare.app.ui.activities.FarmActivityAdapter
import com.smartcropcare.app.ui.crops.AddCropBottomSheetDialog
import com.smartcropcare.app.ui.crops.CropAdapter
import com.smartcropcare.app.ui.disease.AiDiseaseDetectionActivity
import com.smartcropcare.app.ui.dialogs.AddExpenseDialog
import com.smartcropcare.app.ui.dialogs.LogWaterDialog
import com.smartcropcare.app.ui.overview.CropOverviewActivity
import com.smartcropcare.app.ui.passport.DigitalCropPassportActivity
import com.smartcropcare.app.utils.SessionManager
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels {
        val app = requireActivity().application as SmartCropCareApp
        val sessionManager = SessionManager(requireContext())
        HomeViewModel.Factory(app.container.cropRepository, app.container.weatherRepository, sessionManager.getUserId())
    }

    private lateinit var cropAdapter: CropAdapter
    private lateinit var activityAdapter: FarmActivityAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerViews()
        setupBentoGrid()
        setupAddCropButton()
        observeViewModel()
        loadUserProfile()
    }

    private fun loadUserProfile() {
        val sessionManager = SessionManager(requireContext())
        val userId = sessionManager.getUserId()
        val app = requireActivity().application as SmartCropCareApp
        viewLifecycleOwner.lifecycleScope.launch {
            val user = app.container.database.userDao().getUserById(userId)
            if (user != null) {
                binding.tvFarmerNameHome.text = "Hi, ${user.name} 👋"
            }
        }
    }

    private fun setupRecyclerViews() {
        cropAdapter = CropAdapter { crop ->
            val intent = Intent(requireContext(), CropOverviewActivity::class.java).apply {
                putExtra("EXTRA_CROP_ID", crop.id)
            }
            startActivity(intent)
        }
        binding.rvActiveCrops.layoutManager = LinearLayoutManager(requireContext())
        binding.rvActiveCrops.adapter = cropAdapter

        activityAdapter = FarmActivityAdapter { activity, isCompleted ->
            viewModel.toggleActivity(activity.id, isCompleted)
        }
        binding.rvActivities.layoutManager = LinearLayoutManager(requireContext())
        binding.rvActivities.adapter = activityAdapter
    }

    private fun setupBentoGrid() {
        // AI Leaf Scan Bento Card
        binding.bentoAiLeafScan.setOnClickListener {
            val intent = Intent(requireContext(), AiDiseaseDetectionActivity::class.java)
            startActivity(intent)
        }

        // Water Log Bento Card
        binding.bentoWaterLog.setOnClickListener {
            val currentCropId = viewModel.activeCrops.value.firstOrNull()?.id ?: -1L
            if (currentCropId == -1L) {
                Toast.makeText(requireContext(), "Please add a crop first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            LogWaterDialog { liters, duration, method ->
                val app = requireActivity().application as SmartCropCareApp
                lifecycleScope.launch {
                    app.container.cropRepository.logIrrigation(currentCropId, liters, duration, method)
                }
            }.show(childFragmentManager, LogWaterDialog.TAG)
        }

        // Disease Guide Bento Card
        binding.bentoDiseaseGuide.setOnClickListener {
            val intent = Intent(requireContext(), AiDiseaseDetectionActivity::class.java)
            startActivity(intent)
        }

        // Crop Passport Bento Card
        binding.bentoCropPassport.setOnClickListener {
            val currentCropId = viewModel.activeCrops.value.firstOrNull()?.id ?: -1L
            if (currentCropId == -1L) {
                Toast.makeText(requireContext(), "Please add a crop first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(requireContext(), DigitalCropPassportActivity::class.java).apply {
                putExtra("EXTRA_CROP_ID", currentCropId)
            }
            startActivity(intent)
        }

        // Expense Log Bento Card
        binding.bentoExpenseLog.setOnClickListener {
            val currentCropId = viewModel.activeCrops.value.firstOrNull()?.id ?: -1L
            if (currentCropId == -1L) {
                Toast.makeText(requireContext(), "Please add a crop first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            AddExpenseDialog { category, amount, desc ->
                val app = requireActivity().application as SmartCropCareApp
                lifecycleScope.launch {
                    app.container.cropRepository.addExpense(currentCropId, category, amount, desc)
                }
            }.show(childFragmentManager, AddExpenseDialog.TAG)
        }
    }

    private fun setupAddCropButton() {
        binding.cardAddNewCrop.setOnClickListener {
            AddCropBottomSheetDialog { newCrop ->
                val sessionManager = SessionManager(requireContext())
                val cropWithUser = newCrop.copy(userId = sessionManager.getUserId())
                viewModel.addNewCrop(cropWithUser)
                Toast.makeText(requireContext(), "${newCrop.name} added successfully!", Toast.LENGTH_SHORT).show()
            }.show(childFragmentManager, AddCropBottomSheetDialog.TAG)
        }
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.activeCrops.collect { crops ->
                cropAdapter.submitList(crops)
                binding.tvFieldsCount.text = "${crops.size} Fields Active"
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.activities.collect { activities ->
                activityAdapter.submitList(activities)
                val completed = activities.count { it.isCompleted }
                binding.tvActivitiesCount.text = "$completed of ${activities.size} Completed"
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.weather.collect { weather ->
                binding.tvWeatherTemp.text = weather.temperature
                binding.tvWeatherHumidity.text = weather.humidity
                binding.tvWeatherRain.text = weather.rainProbability
                binding.tvWeatherWind.text = weather.windSpeed
                binding.tvWeatherAlert.text = "${weather.advisoryTitle} ${weather.advisoryDescription}"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
