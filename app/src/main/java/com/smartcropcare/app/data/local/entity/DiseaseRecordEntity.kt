package com.smartcropcare.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "disease_records")
data class DiseaseRecordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val cropId: Long,
    val date: String,
    val diseaseName: String,
    val pathogen: String,
    val confidencePct: Double,
    val severityStage: String,
    val observedSymptoms: String,
    val organicTreatment: String,
    val chemicalTreatment: String,
    val imagePath: String? = null,
    val status: String = "Verified"
)
