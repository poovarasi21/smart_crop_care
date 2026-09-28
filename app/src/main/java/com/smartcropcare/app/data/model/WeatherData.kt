package com.smartcropcare.app.data.model

data class WeatherData(
    val temperature: String = "--",
    val humidity: String = "--",
    val rainProbability: String = "--",
    val windSpeed: String = "--",
    val advisoryTitle: String = "Fetching Data...",
    val advisoryDescription: String = "Please wait while we connect to the weather service.",
    val soilTemperature: String = "--",
    val isRealtime: Boolean = false
)
