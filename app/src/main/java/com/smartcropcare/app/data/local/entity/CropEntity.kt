package com.smartcropcare.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crops")
data class CropEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userId: Long = 0,
    val name: String,
    val variety: String,
    val scientificName: String,
    val hybridType: String,
    val plotName: String,
    val zoneBed: String,
    val acreage: Double,
    val soilType: String,
    val plantingDate: String,
    val cropAgeDays: Int,
    val currentStageIndex: Int,
    val stageName: String,
    val stageCompletionPct: Int,
    val healthScore: Int,
    val healthStatus: String,
    val cycleProgressPct: Int,
    val waterStatus: String,
    val fertilizerStatus: String,
    val harvestCountdownDays: Int,
    val imageResName: String,
    val imageUri: String? = null,
    val isActive: Boolean = true,
    val certificateId: String = "SCC-TN-2026-TM882",
    val estimatedYieldTonPerAcre: Double = 18.5,
    val totalInvestment: Double = 14250.0,
    val projectedRevenue: Double = 42000.0,
    val soilMoisturePct: Int = 64
)
