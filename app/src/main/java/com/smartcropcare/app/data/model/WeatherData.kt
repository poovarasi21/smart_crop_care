package com.smartcropcare.app.data.model

data class WeatherData(
    val temperature: String = "29°C",
    val humidity: String = "78%",
    val rainProbability: String = "65%",
    val windSpeed: String = "14km/h",
    val advisoryTitle: String = "High humidity & rain expected by 3 PM.",
    val advisoryDescription: String = "Postpone foliar spraying & check okra for powdery mildew.",
    val soilTemperature: String = "27°C (Ideal)",
    val isRealtime: Boolean = true
)
