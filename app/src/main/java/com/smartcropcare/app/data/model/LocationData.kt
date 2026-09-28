package com.smartcropcare.app.data.model

data class LocationData(
    val latitude: Double,
    val longitude: Double,
    val city: String,
    val state: String = "",
    val country: String = "",
    val isCurrentLocation: Boolean = true
) {
    fun getFormattedName(): String {
        return buildString {
            if (city.isNotEmpty()) append(city)
            if (state.isNotEmpty()) {
                if (isNotEmpty()) append(", ")
                append(state)
            }
            if (country.isNotEmpty()) {
                if (isNotEmpty()) append(", ")
                append(country)
            }
        }
    }
}
