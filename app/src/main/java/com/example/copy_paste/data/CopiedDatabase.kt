package com.example.copy_paste.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Copied::class], version = 1, exportSchema = false)
abstract class CopiedDatabase: RoomDatabase() {

    abstract fun CopiedDao(): CopiedDao
}