package com.example.tuna_test.application

import android.app.Application
import com.example.tuna_test.sharedPref.SharedPref
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TunaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPref.init(this)
    }
}