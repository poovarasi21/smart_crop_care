package com.smartcropcare.app.utils

import android.content.Context
import com.smartcropcare.app.data.model.LocationData

class SessionManager(context: Context) {
    private val prefs = context.getSharedPreferences("user_session", Context.MODE_PRIVATE)

    fun saveUserId(id: Long) {
        prefs.edit().putLong("USER_ID", id).apply()
    }

    fun getUserId(): Long {
        return prefs.getLong("USER_ID", -1)
    }

    fun isLoggedIn(): Boolean {
        return getUserId() != -1L
    }

    fun logout() {
        prefs.edit().clear().apply()
    }

    fun saveLanguage(language: String) {
        prefs.edit().putString("APP_LANG", language).apply()
    }

    fun getLanguage(): String {
        return prefs.getString("APP_LANG", "en") ?: "en"
    }

    fun saveLocation(location: LocationData) {
        prefs.edit().apply {
            putFloat("LOC_LAT", location.latitude.toFloat())
            putFloat("LOC_LON", location.longitude.toFloat())
            putString("LOC_CITY", location.city)
            putString("LOC_STATE", location.state)
            putString("LOC_COUNTRY", location.country)
            putBoolean("LOC_IS_CURRENT", location.isCurrentLocation)
            apply()
        }
    }

    fun getLocation(): LocationData? {
        if (!prefs.contains("LOC_LAT") || !prefs.contains("LOC_LON")) return null
        val lat = prefs.getFloat("LOC_LAT", 0f).toDouble()
        val lon = prefs.getFloat("LOC_LON", 0f).toDouble()
        val city = prefs.getString("LOC_CITY", "") ?: ""
        val state = prefs.getString("LOC_STATE", "") ?: ""
        val country = prefs.getString("LOC_COUNTRY", "") ?: ""
        val isCurrent = prefs.getBoolean("LOC_IS_CURRENT", true)
        return LocationData(lat, lon, city, state, country, isCurrent)
    }

    fun setLocationModeToCurrent() {
        prefs.edit().putBoolean("LOC_IS_CURRENT", true).apply()
    }

    fun isCurrentLocationMode(): Boolean {
        return prefs.getBoolean("LOC_IS_CURRENT", true)
    }
}
