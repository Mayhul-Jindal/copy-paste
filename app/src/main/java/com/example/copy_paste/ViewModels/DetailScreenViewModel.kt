package com.example.copy_paste.ViewModels

import androidx.lifecycle.ViewModel
import com.example.copy_paste.data.Copied
import com.example.copy_paste.data.CopiedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

interface DetailScreenViewModelAbstract{
    val copiedListFlow: Flow<List<Copied>>
    fun addCopied(copied: Copied)
    fun deleteCopied(copied: Copied)
}

@HiltViewModel
class DetailScreenViewModel
@Inject
constructor(
    private val repo: CopiedRepository
): ViewModel(), DetailScreenViewModelAbstract {
    private val ioScope = CoroutineScope(Dispatchers.IO)
    override val copiedListFlow: Flow<List<Copied>> = repo.getAllCopiedFromRoom()

    override fun addCopied(copied: Copied) {
        ioScope.launch { repo.addCopiedToRoom(copied) }
    }

    override fun deleteCopied(copied: Copied) {
        ioScope.launch { repo.deleteCopiedFromRoom(copied) }
    }

}