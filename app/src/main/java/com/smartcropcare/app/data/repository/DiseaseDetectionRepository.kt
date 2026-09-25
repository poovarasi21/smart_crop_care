package com.smartcropcare.app.data.repository

import com.smartcropcare.app.data.local.dao.DiseaseRecordDao
import com.smartcropcare.app.data.local.entity.DiseaseRecordEntity
import com.smartcropcare.app.data.model.DiagnosisResult
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DiseaseDetectionRepository(
    private val diseaseRecordDao: DiseaseRecordDao
) {
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

    /**
     * AI Inference Architecture Layer
     * Formats ICAR-aligned pathology diagnostics for selected crop.
     * Provides pluggable slot for TensorFlow Lite / on-device vision model interpreter.
     */
    fun analyzeLeafImage(cropName: String): DiagnosisResult {
        // TODO: Integrate actual ML Kit or TFLite model here.
        // Currently returning mocked data because no actual model exists in the project.
        return when (cropName.lowercase().trim()) {
            "ladies finger", "okra" -> DiagnosisResult(
                cropName = "Ladies Finger",
                diseaseName = "[MOCK] Yellow Vein Mosaic Virus (YVMV)",
                pathogen = "Begomovirus transmitted by Whitefly (Bemisia tabaci)",
                confidencePct = 89.6,
                severityStage = "Stage 1: Mild",
                observedSymptoms = listOf(
                    "Network of yellow veins on foliage",
                    "Chlorosis spreading into interveinal areas"
                ),
                organicTreatment = "Spray Neem oil 3% (30ml/litre) or install yellow sticky traps (10/acre) to control whitefly vector.",
                chemicalTreatment = "Apply Acetamiprid 20% SP @ 0.5g/litre or Thiamethoxam 25% WG @ 0.3g/litre of water.",
                isSafe = false,
                lesionTag = "Vein #1"
            )
            "brinjal", "eggplant" -> DiagnosisResult(
                cropName = "Brinjal",
                diseaseName = "[MOCK] Shoot and Fruit Borer",
                pathogen = "Lepidopteran larvae internal boring damage",
                confidencePct = 91.2,
                severityStage = "Stage 2: Moderate",
                observedSymptoms = listOf(
                    "Withering and wilting of terminal shoots",
                    "Circular boreholes with frass on young developing fruits"
                ),
                organicTreatment = "Clip and destroy infested shoots. Install pheromone traps with Lucinlure @ 12 traps/acre.",
                chemicalTreatment = "Spray Chlorantraniliprole 18.5% SC @ 0.4ml/litre or Emamectin Benzoate 5% SG @ 0.4g/litre.",
                isSafe = false,
                lesionTag = "Shoot #2"
            )
            "chilli" -> DiagnosisResult(
                cropName = "Chilli",
                diseaseName = "[MOCK] Chilli Leaf Curl Complex",
                pathogen = "Viral complex transmitted by thrips and mites",
                confidencePct = 88.5,
                severityStage = "Stage 1: Mild",
                observedSymptoms = listOf(
                    "Upward leaf curling indicative of thrips attack",
                    "Boat-shaped cupping with reduced leaf lamina"
                ),
                organicTreatment = "Apply Agniastra or spray Pongamia pinnata oil @ 20ml/litre.",
                chemicalTreatment = "Spray Diafenthiuron 50% WP @ 1.2g/litre or Fipronil 5% SC @ 1.5ml/litre.",
                isSafe = false,
                lesionTag = "Curl #1"
            )
            else -> DiagnosisResult(
                cropName = "Tomato",
                diseaseName = "[MOCK] Early Blight Detected",
                pathogen = "Fungal infection prevalent in humid night/warm day cycles",
                confidencePct = 92.4,
                severityStage = "Stage 1: Mild",
                observedSymptoms = listOf(
                    "Concentric dark brown rings: Classic 'target board' pattern visible on older foliage",
                    "Chlorotic margins: Slight yellow halo spreading around the primary lesion periphery"
                ),
                organicTreatment = "Prune infected lower leaves and discard away from field. Avoid overhead sprinkler watering to reduce leaf wetness duration.",
                chemicalTreatment = "Apply Mancozeb 75% WP @ 2g/litre of water or Copper Oxychloride 50% WP @ 2.5g/litre during calm morning hours.",
                isSafe = false,
                lesionTag = "Lesion #1"
            )
        }
    }
}
