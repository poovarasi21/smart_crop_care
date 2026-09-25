package com.smartcropcare.app

import android.app.Application
import com.smartcropcare.app.di.AppContainer

class SmartCropCareApp : Application() {
    lateinit var container: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}
