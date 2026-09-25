package com.smartcropcare.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "irrigation_logs")
data class IrrigationLogEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val cropId: Long,
    val date: String,
    val litersApplied: Int,
    val durationMinutes: Int,
    val method: String,
    val efficiencyPct: Int = 94,
    val soilMoisturePct: Int = 64,
    val notes: String = ""
)
