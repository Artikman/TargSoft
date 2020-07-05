package com.example.cat.listcats.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cat.data.source.ICatsDataSource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class ListCatsViewModelFactory @Inject constructor(
    private val catsDataSource: ICatsDataSource
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListCatsViewModel::class.java)) {
            return ListCatsViewModel(catsDataSource,Dispatchers.Main) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}