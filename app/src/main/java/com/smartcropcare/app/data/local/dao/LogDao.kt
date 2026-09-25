package com.smartcropcare.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.smartcropcare.app.data.local.entity.FertilizerLogEntity
import com.smartcropcare.app.data.local.entity.IrrigationLogEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LogDao {
    @Query("SELECT * FROM irrigation_logs WHERE cropId = :cropId ORDER BY id DESC")
    fun getIrrigationLogs(cropId: Long): Flow<List<IrrigationLogEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIrrigationLog(log: IrrigationLogEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllIrrigation(logs: List<IrrigationLogEntity>)

    @Query("SELECT COUNT(*) FROM irrigation_logs WHERE cropId = :cropId")
    suspend fun getIrrigationSessionCount(cropId: Long): Int

    @Query("SELECT * FROM fertilizer_logs WHERE cropId = :cropId ORDER BY id DESC")
    fun getFertilizerLogs(cropId: Long): Flow<List<FertilizerLogEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFertilizerLog(log: FertilizerLogEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFertilizer(logs: List<FertilizerLogEntity>)

    @Query("SELECT COUNT(*) FROM fertilizer_logs WHERE cropId = :cropId")
    suspend fun getFertilizerDoseCount(cropId: Long): Int
}
