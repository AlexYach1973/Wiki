package com.example.android.wiki.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.wiki.network.ModelProperty

class DetailViewModelFactory (
    private val mProperty : ModelProperty,
    private val application : Application
        ) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(mProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}