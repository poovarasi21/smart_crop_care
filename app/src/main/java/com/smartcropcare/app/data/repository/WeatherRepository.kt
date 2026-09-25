package com.smartcropcare.app.data.repository

import com.smartcropcare.app.data.model.WeatherData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class WeatherRepository {
    private val _currentWeather = MutableStateFlow(
        WeatherData(
            temperature = "29°C",
            humidity = "78%",
            rainProbability = "65%",
            windSpeed = "14km/h",
            advisoryTitle = "High humidity & rain expected by 3 PM.",
            advisoryDescription = "Postpone foliar spraying & check okra for powdery mildew.",
            soilTemperature = "27°C (Ideal Soil Temp)",
            isRealtime = true
        )
    )

    val currentWeather: Flow<WeatherData> = _currentWeather.asStateFlow()

    fun refreshWeatherTelemetry(location: String = "Madurai, TN") {
        // Architecture integration point for live OpenWeather/IMD API
        _currentWeather.value = WeatherData(
            temperature = "29°C",
            humidity = "78%",
            rainProbability = "65%",
            windSpeed = "14km/h",
            advisoryTitle = "High humidity & rain expected by 3 PM.",
            advisoryDescription = "Postpone foliar spraying & check okra for powdery mildew.",
            soilTemperature = "27°C (Ideal Soil Temp)",
            isRealtime = true
        )
    }
}
