package com.smartcropcare.app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.smartcropcare.app.data.local.entity.FarmActivityEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FarmActivityDao {
    @Query("SELECT a.* FROM farm_activities a INNER JOIN crops c ON a.cropId = c.id WHERE c.userId = :userId ORDER BY a.id ASC")
    fun getAllActivities(userId: Long): Flow<List<FarmActivityEntity>>

    @Query("SELECT * FROM farm_activities WHERE cropId = :cropId ORDER BY id ASC")
    fun getActivitiesByCropId(cropId: Long): Flow<List<FarmActivityEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertActivity(activity: FarmActivityEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(activities: List<FarmActivityEntity>)

    @Update
    suspend fun updateActivity(activity: FarmActivityEntity)

    @Query("UPDATE farm_activities SET isCompleted = :isCompleted WHERE id = :id")
    suspend fun updateCompletionStatus(id: Long, isCompleted: Boolean)

    @Delete
    suspend fun deleteActivity(activity: FarmActivityEntity)
}
