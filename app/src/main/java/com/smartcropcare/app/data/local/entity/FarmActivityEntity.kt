package com.smartcropcare.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "farm_activities")
data class FarmActivityEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val cropId: Long,
    val time: String,
    val title: String,
    val tag: String,
    val isCompleted: Boolean,
    val category: String
)
