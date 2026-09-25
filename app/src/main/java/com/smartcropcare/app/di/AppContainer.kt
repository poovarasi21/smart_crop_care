package com.smartcropcare.app.di

import android.content.Context
import com.smartcropcare.app.data.local.AppDatabase
import com.smartcropcare.app.data.repository.CropRepository
import com.smartcropcare.app.data.repository.DiseaseDetectionRepository
import com.smartcropcare.app.data.repository.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class AppContainer(context: Context) {
    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    val database: AppDatabase = AppDatabase.getDatabase(context, applicationScope)

    val cropRepository: CropRepository by lazy {
        CropRepository(
            database.cropDao(),
            database.farmActivityDao(),
            database.logDao(),
            database.diseaseRecordDao(),
            database.expenseDao()
        )
    }

    val weatherRepository: WeatherRepository by lazy {
        WeatherRepository()
    }

    val diseaseDetectionRepository: DiseaseDetectionRepository by lazy {
        DiseaseDetectionRepository(database.diseaseRecordDao())
    }
}
