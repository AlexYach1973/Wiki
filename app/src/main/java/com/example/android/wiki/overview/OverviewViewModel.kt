package com.example.android.wiki.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.wiki.network.ModelProperty
import com.example.android.wiki.network.MyApi
import kotlinx.coroutines.launch

enum class MyApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel : ViewModel() {

    // Внутренняя строка MutableLiveData, в которой хранится самый последний ответ
    private val _status = MutableLiveData<MyApiStatus>()
    val status: LiveData<MyApiStatus>
        get() = _status

    // Когда это LiveData изменяется на ненулевое значение, запускается навигация.
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
    private fun getProperties () {
        // Используем Coroutine
        viewModelScope.launch {
            _status.value = MyApiStatus.LOADING
            try {
                // создает и запускает сетевой вызов в фоновом потоке
                _properties.value = MyApi.retrofitService.getProperties()
                _status.value = MyApiStatus.DONE
                Log.d("myLogs", "_properties.value.size()= " +
                        _properties.value!!.size);

            } catch (e : Exception) {
                Log.d("myLogs", "Exception: $e")
                _status.value = MyApiStatus.ERROR

                // Загружаем пустышку
                val defaultList = listOf(
                    ModelProperty(1, "Ничего не загрузилось", "Alive",
                        "Human","male"),
                    ModelProperty(2, "Morty Smith", "Alive",
                        "Human","male")
                )
                _properties.value = defaultList

//                _properties.value = listOf() // Пустаой список

                Log.d("myLogs", "_status.value: " + _status.value)


            }
        }

    }

    // метод, который устанавливает _ navigateToSelectedProperty для
    // выбранного свойства
    fun displayPropertyDetails(mProperty: ModelProperty) {
        _navigateToSelectedProperty.value = mProperty
    }

    // метод, который обнуляет, чтобы пометить состояние навигации как завершенное
    // и избежать повторного запуска навигации
//    fun displayPropertyDetailsComplete() {
//        _navigateToSelectedProperty.value =  null
//    }

}