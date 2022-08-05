package com.example.copy_paste.ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.copy_paste.data.Copied
import com.example.copy_paste.data.CopiedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val repo: CopiedRepository
): ViewModel(){
    var copiedContents by mutableStateOf(emptyList<Copied>())
    var openDialog by mutableStateOf(false)

    fun getAllCopied() = viewModelScope.launch {
        repo.getAllCopiedFromRoom().collect() { dbCopiedContents ->
            copiedContents = dbCopiedContents
        }
    }

    fun addCopied(copied: Copied) = viewModelScope.launch(Dispatchers.IO) {
        repo.addCopiedToRoom(copied)
    }

}