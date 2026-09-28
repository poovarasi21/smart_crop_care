package com.smartcropcare.app.data.repository

import android.content.Context
import android.graphics.Bitmap
import com.smartcropcare.app.data.disease.PlantDiseaseClassifier
import com.smartcropcare.app.data.local.dao.DiseaseRecordDao
import com.smartcropcare.app.data.local.entity.DiseaseRecordEntity
import com.smartcropcare.app.data.model.DiagnosisResult
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DiseaseDetectionRepository(
    private val diseaseRecordDao: DiseaseRecordDao,
    context: Context
) {
    private val classifier = PlantDiseaseClassifier(context)

    fun getCropMedicalHistory(cropId: Long): Flow<List<DiseaseRecordEntity>> =
        diseaseRecordDao.getRecordsByCropId(cropId)

    suspend fun saveDiagnosis(cropId: Long, result: DiagnosisResult, imagePath: String? = null): Long {
        val record = DiseaseRecordEntity(
            cropId = cropId,
            date = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault()).format(Date()),
            diseaseName = result.diseaseName,
            pathogen = result.pathogen,
            confidencePct = result.confidencePct,
            severityStage = result.severityStage,
            observedSymptoms = result.observedSymptoms.joinToString("; "),
            organicTreatment = result.organicTreatment,
            chemicalTreatment = result.chemicalTreatment,
            imagePath = imagePath,
            status = "Verified"
        )
        return diseaseRecordDao.insertRecord(record)
    }

    fun analyzeLeafImage(bitmap: Bitmap?, cropName: String): DiagnosisResult {
        if (bitmap == null) {
            return DiagnosisResult(
                cropName = cropName,
                diseaseName = "No Image Selected",
                pathogen = "Please capture or upload a clear leaf photo.",
                confidencePct = 0.0,
                severityStage = "--",
                observedSymptoms = listOf("Waiting for leaf photo input."),
                organicTreatment = "N/A",
                chemicalTreatment = "N/A",
                isSafe = false,
                lesionTag = "No Input"
            )
        }

        return classifier.classifyImage(bitmap, cropName)
    }
}
