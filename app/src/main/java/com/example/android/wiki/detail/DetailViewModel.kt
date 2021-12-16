package com.example.android.wiki.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.wiki.network.ModelProperty

class DetailViewModel(mProperty: ModelProperty, app: Application)
    : AndroidViewModel(app) {

    private val _selectedProperty = MutableLiveData<ModelProperty>()
    val selectedProperty: LiveData<ModelProperty>
        get() = _selectedProperty

    init {
        _selectedProperty.value = mProperty
    }

}