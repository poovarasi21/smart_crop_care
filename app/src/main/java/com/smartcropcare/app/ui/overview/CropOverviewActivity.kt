package com.smartcropcare.app.ui.overview

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.smartcropcare.app.R
import com.smartcropcare.app.SmartCropCareApp
import com.smartcropcare.app.data.local.entity.CropEntity
import com.smartcropcare.app.data.model.CropStage
import com.smartcropcare.app.databinding.ActivityCropOverviewBinding
import com.smartcropcare.app.ui.dialogs.AddExpenseDialog
import com.smartcropcare.app.ui.dialogs.LogFertilizerDialog
import com.smartcropcare.app.ui.dialogs.LogHarvestDialog
import com.smartcropcare.app.ui.dialogs.LogPestDialog
import com.smartcropcare.app.ui.dialogs.LogWaterDialog
import com.smartcropcare.app.ui.disease.AiDiseaseDetectionActivity
import com.smartcropcare.app.ui.passport.DigitalCropPassportActivity
import com.smartcropcare.app.utils.SessionManager
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class CropOverviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCropOverviewBinding
    private var cropId: Long = 1L

    private val viewModel: CropOverviewViewModel by viewModels {
        val app = application as SmartCropCareApp
        val sessionManager = SessionManager(this)
        CropOverviewViewModel.Factory(app.container.cropRepository, cropId, sessionManager.getUserId())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCropOverviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cropId = intent.getLongExtra("EXTRA_CROP_ID", 1L)

        setupToolbar()
        setupClickListeners()
        observeViewModel()
    }

    private fun setupToolbar() {
        binding.btnBack.setOnClickListener { finish() }

        binding.btnNavPassport.setOnClickListener {
            val intent = Intent(this, DigitalCropPassportActivity::class.java).apply {
                putExtra("EXTRA_CROP_ID", cropId)
            }
            startActivity(intent)
        }

        binding.btnShareCrop.setOnClickListener {
            val crop = viewModel.crop.value
            val text = if (crop != null) {
                "Smart Crop Care Report: ${crop.name} (${crop.variety} ${crop.plotName}) is currently at ${crop.stageName} (Day ${crop.cropAgeDays}). Health Score: ${crop.healthScore}%. ${crop.waterStatus}."
            } else {
                "Smart Crop Care Report"
            }
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, text)
                type = "text/plain"
            }
            startActivity(Intent.createChooser(sendIntent, "Share Crop Status"))
        }
    }

    private fun setupClickListeners() {
        binding.btnAdvanceStage.setOnClickListener {
            viewModel.advanceStage()
            Toast.makeText(this, "Crop advanced to next lifecycle stage!", Toast.LENGTH_SHORT).show()
        }

        binding.btnMarkAlertDone.setOnClickListener {
            Toast.makeText(this, "Priority task marked completed!", Toast.LENGTH_SHORT).show()
            binding.btnMarkAlertDone.isEnabled = false
            binding.btnMarkAlertDone.text = "Completed ✓"
        }

        binding.btnSnoozeAlert.setOnClickListener {
            Toast.makeText(this, "Alert snoozed for 1 hour", Toast.LENGTH_SHORT).show()
        }

        binding.cardOpWater.setOnClickListener {
            LogWaterDialog { liters, duration, method ->
                viewModel.logIrrigation(liters, duration, method)
                Toast.makeText(this, "Irrigation logged successfully", Toast.LENGTH_SHORT).show()
            }.show(supportFragmentManager, LogWaterDialog.TAG)
        }

        binding.cardOpFertilizer.setOnClickListener {
            LogFertilizerDialog { nutrient, dosage, method ->
                viewModel.logFertilizer(nutrient, dosage, method)
                Toast.makeText(this, "Fertilizer dose logged", Toast.LENGTH_SHORT).show()
            }.show(supportFragmentManager, LogFertilizerDialog.TAG)
        }

        binding.cardOpDisease.setOnClickListener {
            val intent = Intent(this, AiDiseaseDetectionActivity::class.java).apply {
                putExtra("EXTRA_CROP_ID", cropId)
                viewModel.crop.value?.let { putExtra("EXTRA_CROP_NAME", it.name) }
            }
            startActivity(intent)
        }

        binding.cardOpPest.setOnClickListener {
            LogPestDialog { name, symptoms, management, treatment ->
                viewModel.logPest(name, symptoms, management, treatment)
                Toast.makeText(this, "Pest incident recorded", Toast.LENGTH_SHORT).show()
            }.show(supportFragmentManager, LogPestDialog.TAG)
        }

        binding.cardOpHarvest.setOnClickListener {
            LogHarvestDialog { qty, unit, price, notes ->
                viewModel.logHarvest(qty, unit, price, notes)
                Toast.makeText(this, "Harvest yield logged", Toast.LENGTH_SHORT).show()
            }.show(supportFragmentManager, LogHarvestDialog.TAG)
        }

        binding.cardOpExpenses.setOnClickListener {
            AddExpenseDialog { category, amount, desc ->
                viewModel.addExpense(category, amount, desc)
                Toast.makeText(this, "Expense recorded", Toast.LENGTH_SHORT).show()
            }.show(supportFragmentManager, AddExpenseDialog.TAG)
        }

        binding.btnAddDailyLog.setOnClickListener {
            LogWaterDialog { liters, duration, method ->
                viewModel.logIrrigation(liters, duration, method)
                Toast.makeText(this, "Irrigation logged", Toast.LENGTH_SHORT).show()
            }.show(supportFragmentManager, LogWaterDialog.TAG)
        }

        binding.btnScanLeafAi.setOnClickListener {
            val intent = Intent(this, AiDiseaseDetectionActivity::class.java).apply {
                putExtra("EXTRA_CROP_ID", cropId)
                viewModel.crop.value?.let { putExtra("EXTRA_CROP_NAME", it.name) }
            }
            startActivity(intent)
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.crop.collect { crop ->
                crop?.let { bindCropData(it) }
            }
        }

        lifecycleScope.launch {
            viewModel.expenses.collect { list ->
                val total = list.sumOf { it.amount }
                binding.tvExpensesTotal.text = "₹${String.format(Locale.ROOT, "%.2f", total)}"
            }
        }

        lifecycleScope.launch {
            viewModel.pestRecords.collect { list ->
                binding.tvPestSummary.text = if (list.isEmpty()) "No pests logged" else "${list.size} logged (${list[0].pestName})"
            }
        }

        lifecycleScope.launch {
            viewModel.harvests.collect { list ->
                val totalRev = list.sumOf { it.revenue }
                val totalQty = list.sumOf { it.quantity }
                val unit = list.firstOrNull()?.unit ?: "Kg"
                binding.tvHarvestSummary.text = if (list.isEmpty()) "0 Harvested" else "${totalQty.toInt()} $unit (₹${totalRev.toInt()})"
            }
        }
    }

    private fun bindCropData(crop: CropEntity) {
        binding.tvOverviewTitle.text = "${crop.name} — ${crop.plotName.substringBefore("-")}"
        binding.tvOverviewSubtitle.text = crop.zoneBed
        binding.tvHeaderVariety.text = crop.variety
        binding.tvHeaderScientific.text = crop.scientificName
        binding.tvHealthScoreValue.text = "${crop.healthScore}"
        binding.pbCircularHealth.progress = crop.healthScore
        binding.tvHealthScoreGrade.text = crop.healthStatus.uppercase()
        binding.tvPlantingDate.text = crop.plantingDate

        // Calculate DAP (Days After Planting) dynamically
        try {
            val format = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
            val plantDate = format.parse(crop.plantingDate)
            if (plantDate != null) {
                val diffDays = ((Date().time - plantDate.time) / (1000 * 60 * 60 * 24)).coerceAtLeast(0)
                binding.tvCropAgeDap.text = "$diffDays Days"
            } else {
                binding.tvCropAgeDap.text = "${crop.cropAgeDays} Days"
            }
        } catch (e: Exception) {
            binding.tvCropAgeDap.text = "${crop.cropAgeDays} Days"
        }

        binding.tvStageTitle.text = crop.stageName
        binding.tvStageCompletionPct.text = "Stage Completion: ${crop.stageCompletionPct}%"
        binding.tvHarvestCountdownBadge.text = "Harvest in ${crop.harvestCountdownDays}d"
        binding.pbSoilMoisture.progress = crop.soilMoisturePct
        binding.tvMoistureOptimalBadge.text = "${crop.soilMoisturePct}% • Optimal"

        renderStageTrack(crop.currentStageIndex)
    }

    private fun renderStageTrack(currentStageIndex: Int) {
        binding.stageTrackContainer.removeAllViews()

        for (i in CropStage.ALL_STAGES.indices) {
            val stageName = CropStage.ALL_STAGES[i]
            val isCompleted = i < currentStageIndex
            val isCurrent = i == currentStageIndex

            val nodeLayout = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                gravity = Gravity.CENTER_HORIZONTAL
                setPadding(12, 4, 12, 4)
            }

            val circle = View(this).apply {
                val size = if (isCurrent) 36 else 28
                layoutParams = LinearLayout.LayoutParams(size, size)
                setBackgroundResource(
                    if (isCompleted || isCurrent) R.drawable.bg_pill_optimal else R.drawable.bg_pill_neutral
                )
                if (isCurrent) {
                    backgroundTintList = android.content.res.ColorStateList.valueOf(Color.parseColor("#1B5E20"))
                }
            }

            val label = TextView(this).apply {
                text = stageName
                textSize = if (isCurrent) 11f else 10f
                setTextColor(
                    if (isCurrent) Color.parseColor("#1B5E20") else Color.parseColor("#717A6D")
                )
                if (isCurrent) setTypeface(null, android.graphics.Typeface.BOLD)
                setPadding(0, 4, 0, 0)
            }

            nodeLayout.addView(circle)
            nodeLayout.addView(label)
            binding.stageTrackContainer.addView(nodeLayout)
        }
    }
}
