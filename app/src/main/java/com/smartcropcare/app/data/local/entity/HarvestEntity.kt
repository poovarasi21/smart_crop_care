package com.smartcropcare.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "harvests")
data class HarvestEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val cropId: Long,
    val userId: Long,
    val date: String,
    val quantity: Double,
    val unit: String,
    val sellingPrice: Double,
    val revenue: Double,
    val notes: String = ""
)
