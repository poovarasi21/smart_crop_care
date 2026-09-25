package com.smartcropcare.app.utils

import android.content.Context
import android.content.res.Configuration
import java.util.Locale

import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat

object LocaleHelper {
    private const val PREF_KEY_LANG = "app_language"

    fun setLocale(context: Context, languageCode: String): Context {
        persistLanguage(context, languageCode)
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(languageCode))
        return updateResources(context, languageCode)
    }

    fun getLanguage(context: Context): String {
        val prefs = context.getSharedPreferences("smart_crop_care_prefs", Context.MODE_PRIVATE)
        return prefs.getString(PREF_KEY_LANG, "en") ?: "en"
    }

    private fun persistLanguage(context: Context, languageCode: String) {
        val prefs = context.getSharedPreferences("smart_crop_care_prefs", Context.MODE_PRIVATE)
        prefs.edit().putString(PREF_KEY_LANG, languageCode).apply()
    }

    private fun updateResources(context: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)
        return context.createConfigurationContext(config)
    }
}
