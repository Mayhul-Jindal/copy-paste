package com.example.copy_paste

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CopiedRoomApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}