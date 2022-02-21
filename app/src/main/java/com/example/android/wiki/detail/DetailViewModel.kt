package com.example.android.wiki.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.wiki.network.ModelProperty
import javax.inject.Inject

class DetailViewModel @Inject constructor() : ViewModel() {

    private val _selectedProperty = MutableLiveData<ModelProperty>()
    val selectedProperty: LiveData<ModelProperty>
        get() = _selectedProperty

    fun setProperty(mProperty : ModelProperty) {
    _selectedProperty.value = mProperty
    }

}