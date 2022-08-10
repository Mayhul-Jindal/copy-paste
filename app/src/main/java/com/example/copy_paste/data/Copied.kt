package com.example.copy_paste.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "copied_table")
data class Copied (
    @PrimaryKey(autoGenerate = true) var roomId: Long? = null,
    @ColumnInfo(name = "Text") val text: String,
)