package com.smartcropcare.app.ui.passport

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.smartcropcare.app.SmartCropCareApp
import com.smartcropcare.app.data.local.entity.CropEntity
import com.smartcropcare.app.databinding.ActivityDigitalCropPassportBinding
import com.smartcropcare.app.utils.PdfExportHelper
import com.smartcropcare.app.utils.QrCodeHelper
import com.smartcropcare.app.utils.SessionManager
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import java.util.Locale

class DigitalCropPassportActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDigitalCropPassportBinding
    private var cropId: Long = 1L
    private var currentCrop: CropEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDigitalCropPassportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cropId = intent.getLongExtra("EXTRA_CROP_ID", 1L)

        setupToolbar()
        setupActionButtons()
        loadCropPassportData()
    }

    private fun setupToolbar() {
        binding.btnBackPassport.setOnClickListener { finish() }

        binding.btnTopExportPdf.setOnClickListener {
            currentCrop?.let { crop ->
                PdfExportHelper.generateAndSharePassportPdf(this, crop)
            }
        }
    }

    private fun setupActionButtons() {
        binding.btnDownloadPassportPdf.setOnClickListener {
            currentCrop?.let { crop ->
                PdfExportHelper.generateAndSharePassportPdf(this, crop)
            }
        }

        binding.btnSharePassportBuyer.setOnClickListener {
            currentCrop?.let { crop ->
                val text = """
                    Smart Crop Care Official Digital Crop Passport
                    Certificate ID: ${crop.certificateId}
                    Crop: ${crop.name} (${crop.variety} - ${crop.hybridType})
                    Plot: ${crop.plotName} (${crop.acreage} Acres)
                    Health Index: ${crop.healthScore} / 100
                    Estimated Yield: ${crop.estimatedYieldTonPerAcre} Ton/Acre
                    Days to Harvest: ${crop.harvestCountdownDays} Days
                    Verified under Smart Crop Care Autonomous Framework.
                """.trimIndent()

                val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, text)
                    type = "text/plain"
                }
                startActivity(Intent.createChooser(sendIntent, "Share Digital Crop Passport"))
            }
        }
    }

    private fun loadCropPassportData() {
        val app = application as SmartCropCareApp
        val sessionManager = SessionManager(this)
        val userId = sessionManager.getUserId()
        lifecycleScope.launch {
            val crop = app.container.cropRepository.getCropByIdDirect(cropId, userId)
                ?: app.container.cropRepository.getAllActiveCrops(userId).firstOrNull()?.firstOrNull()

            crop?.let {
                currentCrop = it
                val totalExp = app.container.cropRepository.getTotalExpense(it.id)
                val totalRev = app.container.cropRepository.getTotalRevenue(it.id)
                val totalYield = app.container.cropRepository.getTotalYield(it.id)
                bindData(it, totalExp, totalRev, totalYield)
            }
        }
    }

    private fun bindData(crop: CropEntity, realExpense: Double, realRevenue: Double, realYield: Double) {
        binding.tvCertificateId.text = "ID: ${crop.certificateId}"
        binding.tvPassportCropVariety.text = "${crop.name} • ${crop.variety} ${crop.hybridType}"
        binding.tvPassportPlotInfo.text = "${crop.plotName} • ${crop.acreage} Acres"
        binding.tvPassportSoilInfo.text = crop.soilType

        binding.tvKpiHealthScore.text = "${crop.healthScore} / 100"
        binding.tvKpiYield.text = if (realYield > 0) "${String.format(Locale.ROOT, "%.1f", realYield)} Recorded" else "${crop.estimatedYieldTonPerAcre} T/Acre"
        binding.tvKpiInvestment.text = if (realExpense > 0) "₹${realExpense.toInt()}" else "₹${crop.totalInvestment.toInt()}"
        binding.tvKpiRevenue.text = if (realRevenue > 0) "₹${realRevenue.toInt()}" else "₹${crop.projectedRevenue.toInt()}"

        // Generate Scannable QR Code
        try {
            val qrBitmap = QrCodeHelper.generateQrCode("https://smartcropcare.icar.gov.in/verify/${crop.certificateId}", 200)
            binding.ivQrCode.setImageBitmap(qrBitmap)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
