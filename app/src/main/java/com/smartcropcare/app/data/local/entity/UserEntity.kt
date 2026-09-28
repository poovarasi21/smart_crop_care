package com.smartcropcare.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val email: String,
    val passwordHash: String,
    val name: String,
    val profilePhotoUri: String? = null,
    val language: String = "en",
    val phone: String = ""
)
