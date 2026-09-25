package com.smartcropcare.app.utils

import android.content.Context

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
}
