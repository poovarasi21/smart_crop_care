package com.smartcropcare.app.data.repository

import android.location.Location
import com.smartcropcare.app.data.model.WeatherData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class WeatherRepository {
    private val _currentWeather = MutableStateFlow(
        WeatherData(
            temperature = "--",
            humidity = "--",
            rainProbability = "--",
            windSpeed = "--",
            advisoryTitle = "Weather Data Unavailable",
            advisoryDescription = "Please configure a valid OpenWeather API Key to fetch live weather.",
            soilTemperature = "--",
            isRealtime = false
        )
    )

    val currentWeather: Flow<WeatherData> = _currentWeather.asStateFlow()

    // Add your API key here
    private val API_KEY = ""

    fun refreshWeatherTelemetry(location: Location?) {
        if (location == null) {
            _currentWeather.value = WeatherData(
                temperature = "--",
                humidity = "--",
                rainProbability = "--",
                windSpeed = "--",
                advisoryTitle = "Location Unavailable",
                advisoryDescription = "Please enable location services to fetch weather.",
                soilTemperature = "--",
                isRealtime = false
            )
            return
        }

        if (API_KEY.isEmpty()) {
            _currentWeather.value = WeatherData(
                temperature = "API",
                humidity = "Key",
                rainProbability = "Req",
                windSpeed = "--",
                advisoryTitle = "API Key Missing",
                advisoryDescription = "Configure OpenWeather API key in WeatherRepository.kt.",
                soilTemperature = "--",
                isRealtime = false
            )
            return
        }

        try {
            val urlString = "https://api.openweathermap.org/data/2.5/weather?lat=${location.latitude}&lon=${location.longitude}&appid=$API_KEY&units=metric"
            val url = URL(urlString)
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            
            if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                val response = connection.inputStream.bufferedReader().use { it.readText() }
                val jsonObject = JSONObject(response)
                
                val main = jsonObject.getJSONObject("main")
                val temp = main.getDouble("temp").toInt()
                val humidity = main.getInt("humidity")
                
                val wind = jsonObject.getJSONObject("wind")
                val windSpeed = (wind.getDouble("speed") * 3.6).toInt() // m/s to km/h
                
                // Rain is not always present
                var rainProb = "0%"
                if (jsonObject.has("rain")) {
                    val rainObj = jsonObject.getJSONObject("rain")
                    if (rainObj.has("1h")) {
                        val rainVal = rainObj.getDouble("1h")
                        if (rainVal > 0) rainProb = "High"
                    }
                }
                
                val weatherArray = jsonObject.getJSONArray("weather")
                val condition = if (weatherArray.length() > 0) weatherArray.getJSONObject(0).getString("main") else "Clear"

                val (advisoryTitle, advisoryDesc) = generateAdvisory(condition, temp, humidity, windSpeed)

                _currentWeather.value = WeatherData(
                    temperature = "${temp}°C",
                    humidity = "${humidity}%",
                    rainProbability = rainProb,
                    windSpeed = "${windSpeed}km/h",
                    advisoryTitle = advisoryTitle,
                    advisoryDescription = advisoryDesc,
                    soilTemperature = "${temp - 2}°C (Est.)",
                    isRealtime = true
                )
            } else {
                _currentWeather.value = WeatherData(
                    temperature = "Err",
                    humidity = "Err",
                    rainProbability = "--",
                    windSpeed = "--",
                    advisoryTitle = "Weather Fetch Failed",
                    advisoryDescription = "HTTP Error: ${connection.responseCode}",
                    soilTemperature = "--",
                    isRealtime = false
                )
            }
            connection.disconnect()
        } catch (e: Exception) {
            e.printStackTrace()
            _currentWeather.value = WeatherData(
                temperature = "Err",
                humidity = "Err",
                rainProbability = "--",
                windSpeed = "--",
                advisoryTitle = "Weather Error",
                advisoryDescription = e.localizedMessage ?: "Unknown error occurred.",
                soilTemperature = "--",
                isRealtime = false
            )
        }
    }
    
    private fun generateAdvisory(condition: String, temp: Int, humidity: Int, windSpeed: Int): Pair<String, String> {
        if (condition.contains("Rain", ignoreCase = true) || condition.contains("Drizzle", ignoreCase = true)) {
            return Pair("Rain Expected", "Postpone foliar spraying and irrigation.")
        }
        if (humidity > 80 && temp in 20..30) {
            return Pair("High Fungal Risk", "High humidity. Check for powdery mildew or blight.")
        }
        if (windSpeed > 20) {
            return Pair("Strong Winds", "Avoid chemical spraying to prevent drift.")
        }
        if (temp > 35) {
            return Pair("Heat Stress Alert", "High temperatures. Ensure adequate soil moisture.")
        }
        return Pair("Optimal Conditions", "Weather is suitable for regular field operations.")
    }
}
