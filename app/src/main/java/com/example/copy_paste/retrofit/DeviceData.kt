package com.example.copy_paste.retrofit


import com.google.gson.annotations.SerializedName

data class DeviceData(
    @SerializedName("devices")
    val devices: List<Device>
)