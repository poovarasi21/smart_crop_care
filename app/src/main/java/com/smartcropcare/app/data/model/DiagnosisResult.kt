package com.smartcropcare.app.data.model

data class DiagnosisResult(
    val cropName: String,
    val diseaseName: String,
    val pathogen: String,
    val confidencePct: Double,
    val severityStage: String,
    val observedSymptoms: List<String>,
    val organicTreatment: String,
    val chemicalTreatment: String,
    val isSafe: Boolean = false,
    val lesionTag: String = "Lesion #1"
)
