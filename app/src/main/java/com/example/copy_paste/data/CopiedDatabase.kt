package com.example.copy_paste.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Copied::class], version = 1)
abstract class CopiedDatabase: RoomDatabase() {

    abstract fun CopiedDao(): CopiedDao

    companion object{
        private var INSTANCE: CopiedDatabase? = null;
        fun getInstance(context: Context): CopiedDatabase{
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context, CopiedDatabase::class.java, "copied.dp")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE as CopiedDatabase
        }
    }
}