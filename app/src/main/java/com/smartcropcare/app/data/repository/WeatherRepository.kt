package com.smartcropcare.app.data.repository

import android.location.Location
import com.smartcropcare.app.data.model.WeatherData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class WeatherRepository {
    private val _currentWeather = MutableStateFlow(
        WeatherData(
            temperature = "--",
            humidity = "--",
            rainProbability = "--",
            windSpeed = "--",
            condition = "No Data",
            advisoryTitle = "Weather Not Initialized",
            advisoryDescription = "Location and API key required to load live telemetry.",
            soilTemperature = "--",
            isRealtime = false,
            isApiKeyConfigured = false
        )
    )

    val currentWeather: Flow<WeatherData> = _currentWeather.asStateFlow()

    suspend fun refreshWeatherTelemetry(location: Location?, apiKeyOverride: String? = null) = withContext(Dispatchers.IO) {
        if (location == null) {
            _currentWeather.value = WeatherData(
                temperature = "--",
                humidity = "--",
                rainProbability = "--",
                windSpeed = "--",
                condition = "No Location",
                advisoryTitle = "Location Unavailable",
                advisoryDescription = "Please enable GPS or select a farm location in Settings.",
                soilTemperature = "--",
                isRealtime = false,
                isApiKeyConfigured = !apiKeyOverride.isNullOrEmpty()
            )
            return@withContext
        }

        val key = apiKeyOverride?.trim() ?: ""
        if (key.isEmpty()) {
            _currentWeather.value = WeatherData(
                temperature = "--",
                humidity = "--",
                rainProbability = "--",
                windSpeed = "--",
                condition = "Setup Required",
                advisoryTitle = "API Key Missing",
                advisoryDescription = "OpenWeather API Key required. Configure in Settings (Profile tab).",
                soilTemperature = "--",
                isRealtime = false,
                isApiKeyConfigured = false
            )
            return@withContext
        }

        var connection: HttpURLConnection? = null
        try {
            val urlString = "https://api.openweathermap.org/data/2.5/weather?lat=${location.latitude}&lon=${location.longitude}&appid=$key&units=metric"
            val url = URL(urlString)
            connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.connectTimeout = 8000
            connection.readTimeout = 8000
            
            if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                val response = connection.inputStream.bufferedReader().use { it.readText() }
                val jsonObject = JSONObject(response)
                
                val main = jsonObject.getJSONObject("main")
                val temp = main.getDouble("temp").toInt()
                val minTemp = main.optDouble("temp_min", temp.toDouble()).toInt()
                val maxTemp = main.optDouble("temp_max", temp.toDouble()).toInt()
                val humidity = main.getInt("humidity")
                
                val wind = jsonObject.getJSONObject("wind")
                val windSpeed = (wind.getDouble("speed") * 3.6).toInt() // m/s to km/h
                
                var rainProb = "0 mm"
                if (jsonObject.has("rain")) {
                    val rainObj = jsonObject.getJSONObject("rain")
                    if (rainObj.has("1h")) {
                        val rainVal = rainObj.getDouble("1h")
                        rainProb = "${rainVal}mm/h"
                    }
                }
                
                val weatherArray = jsonObject.getJSONArray("weather")
                val condition = if (weatherArray.length() > 0) weatherArray.getJSONObject(0).getString("main") else "Clear"
                val icon = if (weatherArray.length() > 0) weatherArray.getJSONObject(0).optString("icon", "") else ""
                val iconUrl = if (icon.isNotEmpty()) "https://openweathermap.org/img/wn/${icon}@2x.png" else null
                val updatedTime = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date())

                val (advisoryTitle, advisoryDesc) = generateAdvisory(condition, temp, humidity, windSpeed)

                _currentWeather.value = WeatherData(
                    temperature = "${temp}°C",
                    humidity = "${humidity}%",
                    rainProbability = rainProb,
                    windSpeed = "${windSpeed} km/h",
                    condition = condition,
                    minTemp = "${minTemp}°C",
                    maxTemp = "${maxTemp}°C",
                    precipitation = rainProb,
                    updatedTime = updatedTime,
                    weatherIconUrl = iconUrl,
                    advisoryTitle = advisoryTitle,
                    advisoryDescription = advisoryDesc,
                    soilTemperature = "${(temp - 2).coerceAtLeast(15)}°C (Est.)",
                    isRealtime = true,
                    isApiKeyConfigured = true
                )
            } else {
                _currentWeather.value = WeatherData(
                    temperature = "--",
                    humidity = "--",
                    rainProbability = "--",
                    windSpeed = "--",
                    condition = "HTTP ${connection.responseCode}",
                    advisoryTitle = "Weather Fetch Failed",
                    advisoryDescription = if (connection.responseCode == 401) "Invalid API Key. Please check your key in Settings." else "Weather server response: HTTP ${connection.responseCode}",
                    soilTemperature = "--",
                    isRealtime = false,
                    isApiKeyConfigured = true,
                    errorState = "HTTP ${connection.responseCode}"
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            _currentWeather.value = WeatherData(
                temperature = "--",
                humidity = "--",
                rainProbability = "--",
                windSpeed = "--",
                condition = "Offline",
                advisoryTitle = "Network Offline / Error",
                advisoryDescription = e.localizedMessage ?: "Could not connect to weather service.",
                soilTemperature = "--",
                isRealtime = false,
                isApiKeyConfigured = true,
                errorState = e.localizedMessage
            )
        } finally {
            connection?.disconnect()
        }
    }
    
    private fun generateAdvisory(condition: String, temp: Int, humidity: Int, windSpeed: Int): Pair<String, String> {
        if (condition.contains("Rain", ignoreCase = true) || condition.contains("Drizzle", ignoreCase = true) || condition.contains("Thunderstorm", ignoreCase = true)) {
            return Pair("Rain Expected", "Postpone foliar spraying and chemical applications to prevent runoff.")
        }
        if (humidity > 80 && temp in 20..32) {
            return Pair("High Fungal Risk", "High humidity and warm canopy temperatures. Inspect crops for mildew or blight.")
        }
        if (windSpeed > 20) {
            return Pair("Strong Winds Warning", "High wind speeds (${windSpeed} km/h). Avoid foliar spraying to prevent spray drift.")
        }
        if (temp > 35) {
            return Pair("Heat Stress Alert", "High temperature detected (${temp}°C). Ensure timely drip irrigation.")
        }
        return Pair("Optimal Farm Conditions", "Microclimate is suitable for regular field activities and spraying.")
    }
}
