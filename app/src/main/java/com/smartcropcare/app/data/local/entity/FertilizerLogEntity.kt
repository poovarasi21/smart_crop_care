package com.smartcropcare.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fertilizer_logs")
data class FertilizerLogEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val cropId: Long,
    val date: String,
    val nutrientName: String,
    val dosage: String,
    val applicationMethod: String,
    val adherenceStatus: String = "On-Time"
)
