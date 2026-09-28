package com.smartcropcare.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pest_records")
data class PestRecordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val cropId: Long,
    val date: String,
    val pestName: String,
    val damageSymptoms: String,
    val managementAction: String,
    val treatmentNotes: String,
    val imagePath: String? = null
)
