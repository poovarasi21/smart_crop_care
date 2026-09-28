package com.smartcropcare.app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.smartcropcare.app.data.local.entity.PestRecordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PestDao {
    @Query("SELECT * FROM pest_records WHERE cropId = :cropId ORDER BY id DESC")
    fun getPestsByCropId(cropId: Long): Flow<List<PestRecordEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPest(pest: PestRecordEntity): Long

    @Delete
    suspend fun deletePest(pest: PestRecordEntity)
}
