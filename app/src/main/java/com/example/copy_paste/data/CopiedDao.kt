package com.example.copy_paste.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CopiedDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCopied(copied: Copied)

    @Query("SELECT * FROM copied_table ORDER BY id DESC")
    fun getAllCopied(): Flow<List<Copied>>

    @Query("SELECT * FROM copied_table WHERE id = :id")
    fun getSpecificCopiedT(id: Int): Copied
}