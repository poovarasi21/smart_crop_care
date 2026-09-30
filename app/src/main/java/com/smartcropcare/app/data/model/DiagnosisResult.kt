package com.smartcropcare.app.data.model

data class DiagnosisResult(
    val cropName: String,
    val diseaseName: String,
    val diseaseNameTamil: String = "",
    val pathogen: String = "",
    val confidencePct: Double = 0.0,
    val severityStage: String = "--",
    val observedSymptoms: List<String> = emptyList(),
    val observedSymptomsTamil: List<String> = emptyList(),
    val culturalManagement: String = "",
    val biologicalManagement: String = "",
    val chemicalTreatment: String = "",
    val organicTreatment: String = "",
    val prevention: String = "",
    val sourceReference: String = "ICAR-IIHR / TNAU Agritech Portal",
    val isSafe: Boolean = false,
    val lesionTag: String = "Field Diagnostic"
)
