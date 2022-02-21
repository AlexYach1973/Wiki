package com.example.android.wiki.overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.wiki.network.MyService
import java.lang.IllegalArgumentException

/*
class OverviewViewModelFactory (private val myService : MyService)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(OverviewViewModel::class.java)) {
            return OverviewViewModel(myService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}*/
