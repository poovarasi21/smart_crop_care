package com.smartcropcare.app.data.repository

import com.smartcropcare.app.data.local.dao.*
import com.smartcropcare.app.data.local.entity.*
import com.smartcropcare.app.data.model.CropStage
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class CropRepository(
    private val cropDao: CropDao,
    private val activityDao: FarmActivityDao,
    private val logDao: LogDao,
    private val diseaseRecordDao: DiseaseRecordDao,
    private val expenseDao: ExpenseDao,
    private val pestDao: PestDao
) {
    fun getAllActiveCrops(userId: Long): Flow<List<CropEntity>> = cropDao.getAllActiveCrops(userId)
    fun getAllActivities(userId: Long): Flow<List<FarmActivityEntity>> = activityDao.getAllActivities(userId)

    fun getCropById(id: Long, userId: Long): Flow<CropEntity?> = cropDao.getCropById(id, userId)
    suspend fun getCropByIdDirect(id: Long, userId: Long): CropEntity? = cropDao.getCropByIdDirect(id, userId)

    suspend fun insertCrop(crop: CropEntity): Long = cropDao.insertCrop(crop)

    suspend fun advanceStage(cropId: Long, userId: Long) {
        val current = cropDao.getCropByIdDirect(cropId, userId) ?: return
        val nextIndex = (current.currentStageIndex + 1).coerceAtMost(CropStage.ALL_STAGES.size - 1)
        val stageName = "${CropStage.ALL_STAGES[nextIndex]} Stage"
        val completionPct = ((nextIndex + 1) * 100) / CropStage.ALL_STAGES.size
        val newHarvestCountdown = (28 - (nextIndex - 4) * 14).coerceAtLeast(0)

        cropDao.updateStage(cropId, nextIndex, stageName, completionPct, newHarvestCountdown)
    }

    suspend fun updateActivityStatus(id: Long, isCompleted: Boolean) {
        activityDao.updateCompletionStatus(id, isCompleted)
    }

    suspend fun addActivity(activity: FarmActivityEntity): Long {
        return activityDao.insertActivity(activity)
    }

    fun getIrrigationLogs(cropId: Long): Flow<List<IrrigationLogEntity>> =
        logDao.getIrrigationLogs(cropId)

    suspend fun logIrrigation(cropId: Long, liters: Int, duration: Int, method: String, notes: String = ""): Long {
        val log = IrrigationLogEntity(
            cropId = cropId,
            date = "Today " + SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date()),
            litersApplied = liters,
            durationMinutes = duration,
            method = method,
            efficiencyPct = 95,
            soilMoisturePct = 68,
            notes = notes
        )
        cropDao.updateMoisture(cropId, 68)
        return logDao.insertIrrigationLog(log)
    }

    fun getFertilizerLogs(cropId: Long): Flow<List<FertilizerLogEntity>> =
        logDao.getFertilizerLogs(cropId)

    suspend fun logFertilizer(cropId: Long, nutrient: String, dosage: String, method: String): Long {
        val log = FertilizerLogEntity(
            cropId = cropId,
            date = "Today " + SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date()),
            nutrientName = nutrient,
            dosage = dosage,
            applicationMethod = method,
            adherenceStatus = "On-Time"
        )
        return logDao.insertFertilizerLog(log)
    }

    fun getExpenses(cropId: Long): Flow<List<ExpenseEntity>> =
        expenseDao.getExpensesByCropId(cropId)

    suspend fun addExpense(cropId: Long, category: String, amount: Double, description: String): Long {
        val expense = ExpenseEntity(
            cropId = cropId,
            date = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(Date()),
            category = category,
            amount = amount,
            description = description
        )
        return expenseDao.insertExpense(expense)
    }

    suspend fun getTotalExpense(cropId: Long): Double {
        return expenseDao.getTotalExpense(cropId) ?: 0.0
    }

    fun getPestRecords(cropId: Long): Flow<List<PestRecordEntity>> =
        pestDao.getPestsByCropId(cropId)

    suspend fun logPest(cropId: Long, pestName: String, damage: String, management: String, treatment: String): Long {
        val record = PestRecordEntity(
            cropId = cropId,
            date = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault()).format(Date()),
            pestName = pestName,
            damageSymptoms = damage,
            managementAction = management,
            treatmentNotes = treatment
        )
        return pestDao.insertPest(record)
    }

    suspend fun getIrrigationCount(cropId: Long): Int = logDao.getIrrigationSessionCount(cropId)
    suspend fun getFertilizerCount(cropId: Long): Int = logDao.getFertilizerDoseCount(cropId)
    suspend fun getScanCount(cropId: Long): Int = diseaseRecordDao.getScanCount(cropId)
}
