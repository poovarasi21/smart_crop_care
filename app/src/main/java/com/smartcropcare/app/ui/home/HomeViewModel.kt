package com.smartcropcare.app.ui.home

import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.smartcropcare.app.data.local.entity.CropEntity
import com.smartcropcare.app.data.local.entity.FarmActivityEntity
import com.smartcropcare.app.data.model.WeatherData
import com.smartcropcare.app.data.repository.CropRepository
import com.smartcropcare.app.data.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(
    private val cropRepository: CropRepository,
    private val weatherRepository: WeatherRepository,
    private val userId: Long
) : ViewModel() {

    val activeCrops: StateFlow<List<CropEntity>> = cropRepository.getAllActiveCrops(userId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val activities: StateFlow<List<FarmActivityEntity>> = cropRepository.getAllActivities(userId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val weather: StateFlow<WeatherData> = weatherRepository.currentWeather
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), WeatherData())

    fun refreshWeather(location: Location?) {
        viewModelScope.launch(Dispatchers.IO) {
            weatherRepository.refreshWeatherTelemetry(location)
        }
    }

    fun toggleActivity(id: Long, isCompleted: Boolean) {
        viewModelScope.launch {
            cropRepository.updateActivityStatus(id, isCompleted)
        }
    }

    fun addNewCrop(crop: CropEntity) {
        viewModelScope.launch {
            cropRepository.insertCrop(crop)
        }
    }

    class Factory(
        private val cropRepository: CropRepository,
        private val weatherRepository: WeatherRepository,
        private val userId: Long
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeViewModel(cropRepository, weatherRepository, userId) as T
        }
    }
}
