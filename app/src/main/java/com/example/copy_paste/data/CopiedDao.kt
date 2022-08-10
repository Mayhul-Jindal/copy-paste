package com.example.copy_paste.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CopiedDao {
    @Query("SELECT * FROM copied_table")
    fun getAllCopied(): Flow<List<Copied>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCopied(copied: Copied)

    @Delete
    suspend fun deleteCopied(copied: Copied)
}