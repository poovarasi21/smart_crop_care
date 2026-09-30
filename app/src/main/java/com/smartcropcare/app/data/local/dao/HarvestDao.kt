package com.smartcropcare.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.smartcropcare.app.data.local.entity.HarvestEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HarvestDao {
    @Query("SELECT * FROM harvests WHERE cropId = :cropId ORDER BY id DESC")
    fun getHarvestsByCropId(cropId: Long): Flow<List<HarvestEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHarvest(harvest: HarvestEntity): Long

    @Query("SELECT SUM(revenue) FROM harvests WHERE cropId = :cropId")
    suspend fun getTotalRevenue(cropId: Long): Double?

    @Query("SELECT SUM(quantity) FROM harvests WHERE cropId = :cropId")
    suspend fun getTotalYield(cropId: Long): Double?
}
