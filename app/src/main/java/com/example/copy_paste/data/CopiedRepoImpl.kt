package com.example.copy_paste.data

import androidx.lifecycle.LiveData

class CopiedRepoImpl(
    private val CopiedDao: CopiedDao
): CopiedRepository{
    override suspend fun getAllCopiedFromRoom() = CopiedDao.getAllCopied()
    override suspend fun getCopiedFromRoom(id: Int) = CopiedDao.getSpecificCopiedT(id)
    override suspend fun addCopiedToRoom(copied: Copied) = CopiedDao.addCopied(copied)
}