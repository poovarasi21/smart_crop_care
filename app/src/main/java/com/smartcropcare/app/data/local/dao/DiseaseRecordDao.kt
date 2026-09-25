package com.smartcropcare.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.smartcropcare.app.data.local.entity.DiseaseRecordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DiseaseRecordDao {
    @Query("SELECT * FROM disease_records WHERE cropId = :cropId ORDER BY id DESC")
    fun getRecordsByCropId(cropId: Long): Flow<List<DiseaseRecordEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecord(record: DiseaseRecordEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(records: List<DiseaseRecordEntity>)

    @Query("SELECT COUNT(*) FROM disease_records WHERE cropId = :cropId")
    suspend fun getScanCount(cropId: Long): Int
}
