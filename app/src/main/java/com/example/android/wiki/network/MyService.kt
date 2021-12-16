package com.example.android.wiki.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query



private const val BASE_URL = "https://rickandmortyapi.com"

// Создание экземпляра Moshi
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// конструктор Retrofit для создания объекта Retrofit
private val retrofit = Retrofit.Builder()
    // Необходимо как минмум две вещи:
    .addConverterFactory(MoshiConverterFactory.create(moshi)) // первая
    .baseUrl(BASE_URL) // Вторая
    .build()

//  интерфейс, который определяет, как Retrofit взаимодействует с веб-сервером
//  с помощью HTTP-запросов
interface MyService {
    @GET("api/character")
    // Используем coroutines
//    suspend fun getProperties(@Query("name") type: String): List<ModelProperty>
    suspend fun getProperties(): List<ModelProperty>
}

// инициализация службы Retrofit
object MyApi {
    val retrofitService: MyService by lazy {
        retrofit.create(MyService::class.java)
    }
}