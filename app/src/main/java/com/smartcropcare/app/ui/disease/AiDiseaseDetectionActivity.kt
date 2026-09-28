package com.smartcropcare.app.ui.disease

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.smartcropcare.app.R
import com.smartcropcare.app.SmartCropCareApp
import com.smartcropcare.app.data.model.DiagnosisResult
import com.smartcropcare.app.databinding.ActivityAiDiseaseDetectionBinding
import kotlinx.coroutines.launch

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.ImageDecoder
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.core.app.ActivityCompat

class AiDiseaseDetectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAiDiseaseDetectionBinding
    private var laserAnimator: ObjectAnimator? = null

    private val CAMERA_PERMISSION_REQUEST_CODE = 1001

    private val viewModel: DiseaseDetectionViewModel by viewModels {
        val app = application as SmartCropCareApp
        DiseaseDetectionViewModel.Factory(app.container.diseaseDetectionRepository)
    }

    // Camera Capture Result
    private val takePhotoLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val bitmap = result.data?.extras?.get("data") as? Bitmap
            bitmap?.let {
                binding.ivLeafPreview.setImageBitmap(it)
                viewModel.startAnalysis(it)
            }
        }
    }

    // Gallery Picker Result
    private val pickImageLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            try {
                binding.ivLeafPreview.setImageURI(it)
                val bitmap = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    ImageDecoder.decodeBitmap(ImageDecoder.createSource(contentResolver, it))
                } else {
                    @Suppress("DEPRECATION")
                    MediaStore.Images.Media.getBitmap(contentResolver, it)
                }
                viewModel.startAnalysis(bitmap)
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this, "Failed to decode leaf image.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAiDiseaseDetectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupCropChips()
        setupCaptureButtons()
        startLaserScanAnimation()
        observeViewModel()
    }

    private fun setupToolbar() {
        binding.btnBackDisease.setOnClickListener { finish() }

        binding.btnInfoDialog.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Agronomy Vision AI Model")
                .setMessage("Smart Crop Care v2.4 utilizes quantized vision heuristics aligned with ICAR-IIHR diagnostic protocols for Tamil Nadu climatic conditions.")
                .setPositiveButton("OK", null)
                .show()
        }
    }

    private fun setupCropChips() {
        binding.chipTomato.setOnClickListener { viewModel.selectCrop("Tomato") }
        binding.chipOkra.setOnClickListener { viewModel.selectCrop("Ladies Finger") }
        binding.chipBrinjal.setOnClickListener { viewModel.selectCrop("Brinjal") }
        binding.chipChilli.setOnClickListener { viewModel.selectCrop("Chilli") }
    }

    private fun setupCaptureButtons() {
        binding.btnTakePhoto.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                openCamera()
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_REQUEST_CODE)
            }
        }

        binding.btnUploadGallery.setOnClickListener {
            pickImageLauncher.launch("image/*")
        }

        binding.btnSaveMedicalHistory.setOnClickListener {
            viewModel.saveToMedicalHistory(1)
            Toast.makeText(this, "Diagnosis saved to Crop Medical History!", Toast.LENGTH_SHORT).show()
        }

        binding.btnShareKvk.setOnClickListener {
            val result = viewModel.diagnosisResult.value
            val shareText = """
                Smart Crop Care AI Diagnostic Report
                Crop: ${result.cropName}
                Diagnosis: ${result.diseaseName} (${result.confidencePct}% Match)
                Severity: ${result.severityStage}
                Symptoms: ${result.observedSymptoms.joinToString(", ")}
                Recommended Spray: ${result.chemicalTreatment}
                Organic Control: ${result.organicTreatment}
            """.trimIndent()

            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, shareText)
                type = "text/plain"
            }
            startActivity(Intent.createChooser(sendIntent, "Share Diagnostic Report with KVK"))
        }
    }

    private fun openCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            takePhotoLauncher.launch(takePictureIntent)
        } catch (e: Exception) {
            Toast.makeText(this, "Camera not available: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera()
            } else {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                    AlertDialog.Builder(this)
                        .setTitle("Camera Permission Denied")
                        .setMessage("Camera permission is required to capture leaf images. Please enable it in Settings.")
                        .setPositiveButton("OK", null)
                        .show()
                } else {
                    Toast.makeText(this, "Camera permission is required.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun startLaserScanAnimation() {
        laserAnimator = ObjectAnimator.ofFloat(
            binding.viewLaserLine,
            "translationY",
            0f,
            500f
        ).apply {
            duration = 2000
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
            interpolator = AccelerateDecelerateInterpolator()
            start()
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.diagnosisResult.collect { result ->
                bindDiagnosisResult(result)
            }
        }

        lifecycleScope.launch {
            viewModel.isAnalyzing.collect { isAnalyzing ->
                binding.tvScanStateBadge.text = if (isAnalyzing) getString(R.string.scan_state_scanning) else getString(R.string.scan_state_complete)
            }
        }
    }

    private fun bindDiagnosisResult(result: DiagnosisResult) {
        binding.tvDiseaseName.text = result.diseaseName
        binding.tvDiseasePathogen.text = result.pathogen
        binding.tvConfidenceText.text = getString(R.string.match_format, result.confidencePct.toInt())
        binding.pbConfidence.progress = result.confidencePct.toInt()
        binding.tvSeverityStage.text = result.severityStage
        binding.tvLesionTag.text = result.lesionTag
        binding.tvLesionConfidence.text = getString(R.string.conf_format, result.confidencePct.toInt())

        val symptomsFormatted = result.observedSymptoms.joinToString("\n") { "• $it" }
        binding.tvSymptomsList.text = symptomsFormatted
        binding.tvOrganicTreatment.text = result.organicTreatment
        binding.tvChemicalTreatment.text = result.chemicalTreatment
    }

    override fun onDestroy() {
        super.onDestroy()
        laserAnimator?.cancel()
    }
}
