package com.smartcropcare.app.data.model

data class WeatherData(
    val temperature: String = "--",
    val humidity: String = "--",
    val rainProbability: String = "--",
    val windSpeed: String = "--",
    val condition: String = "--",
    val minTemp: String = "--",
    val maxTemp: String = "--",
    val precipitation: String = "--",
    val updatedTime: String = "--",
    val weatherIconUrl: String? = null,
    val advisoryTitle: String = "Fetching Data...",
    val advisoryDescription: String = "Please wait while we connect to the weather service.",
    val soilTemperature: String = "--",
    val isRealtime: Boolean = false,
    val isApiKeyConfigured: Boolean = false,
    val errorState: String? = null
)
