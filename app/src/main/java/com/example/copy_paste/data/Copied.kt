package com.example.copy_paste.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "copied_table")
data class Copied (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val copiedText: String,
)