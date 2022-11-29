package com.example.copy_paste.retrofit

import android.graphics.Movie
import retrofit2.http.GET

interface CopyPasteApiInterface {
    @GET("/api/v1/user/devices")
    suspend fun getDevices(): List<DeviceData>
}