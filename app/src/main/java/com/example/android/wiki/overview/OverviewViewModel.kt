package com.example.android.wiki.overview

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.wiki.network.ModelProperty
import com.example.android.wiki.network.MyService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

//@Singleton
class OverviewViewModel @Inject constructor(private val myService : MyService) : ViewModel() {

    // запускается навигация с аргументом
    private val _navigateToSelectedProperty = MutableLiveData<ModelProperty>()
    val navigateToSelectedProperty: LiveData<ModelProperty>
        get() = _navigateToSelectedProperty

    //property Rick & Morty object
    private val _properties = MutableLiveData<List<ModelProperty>>()
    val properties: LiveData<List<ModelProperty>>
        get() = _properties

    // при инициализации, чтобы мы могли немедленно отобразить статус
    init {
        getProperties()
    }

    // Получаем информацию из сервиса
    @SuppressLint("CheckResult")
    private fun getProperties() {

        // Потому-что Dagger
//        val getModelResponse = MyApi.retrofitService.getProperties()

        /**  Используем RxJava  */
        val getModelResponse = myService.getProperties()

        getModelResponse
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { it ->
                    _properties.value = it.results
                },
                { error ->
                    // Логируем ошибку
                    Log.e("myLogs", error.toString())
                })
    }

    // метод, который устанавливает _ navigateToSelectedProperty для
    // выбранного свойства
    fun displayPropertyDetails(mProperty: ModelProperty) {
        _navigateToSelectedProperty.value = mProperty
    }
}