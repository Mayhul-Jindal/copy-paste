package com.example.copy_paste.retrofit


import com.google.gson.annotations.SerializedName

data class Device(
    @SerializedName("_id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("type")
    val type: String
)