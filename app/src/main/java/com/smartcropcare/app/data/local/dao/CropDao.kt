package com.smartcropcare.app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.smartcropcare.app.data.local.entity.CropEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CropDao {
    @Query("SELECT * FROM crops WHERE isActive = 1 AND userId = :userId ORDER BY id ASC")
    fun getAllActiveCrops(userId: Long): Flow<List<CropEntity>>

    @Query("SELECT * FROM crops WHERE id = :id AND userId = :userId LIMIT 1")
    fun getCropById(id: Long, userId: Long): Flow<CropEntity?>

    @Query("SELECT * FROM crops WHERE id = :id AND userId = :userId LIMIT 1")
    suspend fun getCropByIdDirect(id: Long, userId: Long): CropEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCrop(crop: CropEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(crops: List<CropEntity>)

    @Update
    suspend fun updateCrop(crop: CropEntity)

    @Delete
    suspend fun deleteCrop(crop: CropEntity)

    @Query("UPDATE crops SET currentStageIndex = :stageIndex, stageName = :stageName, stageCompletionPct = :completionPct, harvestCountdownDays = :daysToHarvest WHERE id = :cropId")
    suspend fun updateStage(cropId: Long, stageIndex: Int, stageName: String, completionPct: Int, daysToHarvest: Int)

    @Query("UPDATE crops SET healthScore = :healthScore, healthStatus = :healthStatus WHERE id = :cropId")
    suspend fun updateHealth(cropId: Long, healthScore: Int, healthStatus: String)

    @Query("UPDATE crops SET soilMoisturePct = :moisturePct WHERE id = :cropId")
    suspend fun updateMoisture(cropId: Long, moisturePct: Int)
}
