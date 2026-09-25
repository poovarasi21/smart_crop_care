package com.smartcropcare.app.ui.disease

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.smartcropcare.app.data.model.DiagnosisResult
import com.smartcropcare.app.data.repository.DiseaseDetectionRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DiseaseDetectionViewModel(
    private val repository: DiseaseDetectionRepository
) : ViewModel() {

    private val _selectedCrop = MutableStateFlow("Tomato")
    val selectedCrop: StateFlow<String> = _selectedCrop.asStateFlow()

    private val _isAnalyzing = MutableStateFlow(false)
    val isAnalyzing: StateFlow<Boolean> = _isAnalyzing.asStateFlow()

    private val _diagnosisResult = MutableStateFlow(repository.analyzeLeafImage("Tomato"))
    val diagnosisResult: StateFlow<DiagnosisResult> = _diagnosisResult.asStateFlow()

    private val _isSaved = MutableStateFlow(false)
    val isSaved: StateFlow<Boolean> = _isSaved.asStateFlow()

    fun selectCrop(cropName: String) {
        _selectedCrop.value = cropName
        _diagnosisResult.value = repository.analyzeLeafImage(cropName)
        _isSaved.value = false
    }

    fun startAnalysis(cropName: String = _selectedCrop.value) {
        viewModelScope.launch {
            _isAnalyzing.value = true
            delay(1500) // Simulate on-device neural inference and laser scan
            _diagnosisResult.value = repository.analyzeLeafImage(cropName)
            _isAnalyzing.value = false
            _isSaved.value = false
        }
    }

    fun saveToMedicalHistory(cropId: Long = 1) {
        viewModelScope.launch {
            repository.saveDiagnosis(cropId, _diagnosisResult.value)
            _isSaved.value = true
        }
    }

    class Factory(
        private val repository: DiseaseDetectionRepository
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return DiseaseDetectionViewModel(repository) as T
        }
    }
}
