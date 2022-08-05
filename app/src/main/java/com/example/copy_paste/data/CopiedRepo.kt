package com.example.copy_paste.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

interface CopiedRepository{
    suspend fun getAllCopiedFromRoom(): Flow<List<Copied>>

    suspend fun getCopiedFromRoom(id: Int): Copied

    suspend fun addCopiedToRoom(copied: Copied)
}


//class CopiedRepo(private val userDao: CopiedDao) {
//    val getAllCopied: LiveData<List<Copied>> = userDao.getAllCopied()
//
//    suspend fun addCopied(copied: Copied){
//        userDao.addCopied(copied)
//    }
//}