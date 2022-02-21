package com.example.android.wiki.overview

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.wiki.network.ModelProperty
import com.example.android.wiki.network.MyApi
import com.example.android.wiki.network.MyService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class OverviewViewModel @Inject constructor() : ViewModel() {

//    @Inject
    lateinit var myService : MyService /*= ()
//        DaggerAppComponent.factory().create().inject(this)*/


//    private val myService : MyService = ()
//        DaggerAppComponent.factory().create().inject(this)

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

        /**  Используем RxJava  */
        val getModelResponse = MyApi.retrofitService.getProperties()

        // Dagger
//        val getModelResponse = myService.getProperties()

//        Log.d("myLogs", "ModelResponse: $getModelResponse")

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