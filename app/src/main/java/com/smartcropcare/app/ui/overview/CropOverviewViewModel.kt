package com.smartcropcare.app.ui.overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.smartcropcare.app.data.local.entity.*
import com.smartcropcare.app.data.repository.CropRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CropOverviewViewModel(
    private val cropRepository: CropRepository,
    private val cropId: Long,
    private val userId: Long
) : ViewModel() {

    val crop: StateFlow<CropEntity?> = cropRepository.getCropById(cropId, userId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val irrigationLogs: StateFlow<List<IrrigationLogEntity>> = cropRepository.getIrrigationLogs(cropId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val fertilizerLogs: StateFlow<List<FertilizerLogEntity>> = cropRepository.getFertilizerLogs(cropId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val expenses: StateFlow<List<ExpenseEntity>> = cropRepository.getExpenses(cropId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val pestRecords: StateFlow<List<PestRecordEntity>> = cropRepository.getPestRecords(cropId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val harvests: StateFlow<List<HarvestEntity>> = cropRepository.getHarvests(cropId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun advanceStage() {
        viewModelScope.launch {
            cropRepository.advanceStage(cropId, userId)
        }
    }

    fun logIrrigation(liters: Int, duration: Int, method: String) {
        viewModelScope.launch {
            cropRepository.logIrrigation(cropId, liters, duration, method)
        }
    }

    fun logFertilizer(nutrient: String, dosage: String, method: String) {
        viewModelScope.launch {
            cropRepository.logFertilizer(cropId, nutrient, dosage, method)
        }
    }

    fun addExpense(category: String, amount: Double, desc: String) {
        viewModelScope.launch {
            cropRepository.addExpense(cropId, category, amount, desc)
        }
    }

    fun logPest(name: String, symptoms: String, management: String, treatment: String) {
        viewModelScope.launch {
            cropRepository.logPest(cropId, name, symptoms, management, treatment)
        }
    }

    fun logHarvest(quantity: Double, unit: String, sellingPrice: Double, notes: String) {
        viewModelScope.launch {
            cropRepository.addHarvest(cropId, userId, quantity, unit, sellingPrice, notes)
        }
    }

    fun deleteCrop(onDone: () -> Unit) {
        viewModelScope.launch {
            crop.value?.let {
                cropRepository.deleteCrop(it)
                onDone()
            }
        }
    }

    class Factory(
        private val cropRepository: CropRepository,
        private val cropId: Long,
        private val userId: Long
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CropOverviewViewModel(cropRepository, cropId, userId) as T
        }
    }
}
