package com.example.copy_paste.data

import kotlinx.coroutines.flow.Flow


class CopiedRepository(
    private val copiedDao: CopiedDao
){
    fun getAllCopiedFromRoom(): Flow<List<Copied>> = copiedDao.getAllCopied()
    suspend fun addCopiedToRoom(copied: Copied) = copiedDao.addCopied(copied)
    suspend fun deleteCopiedFromRoom(copied: Copied) = copiedDao.deleteCopied(copied)
}