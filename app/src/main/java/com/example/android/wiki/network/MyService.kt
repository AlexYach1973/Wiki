package com.example.android.wiki.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_URL = "https://rickandmortyapi.com/api/"

// Создание экземпляра Moshi
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// конструктор Retrofit для создания объекта Retrofit
private val retrofit = Retrofit.Builder()
    // Необходимо как минмум две вещи:
    .baseUrl(BASE_URL) // первая
//    .addConverterFactory(MoshiConverterFactory.create(moshi)) // Вторая
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()

//  интерфейс, который определяет, как Retrofit взаимодействует с веб-сервером
//  с помощью HTTP-запросов
/*

interface MyService {
    @GET("character/[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]")
    // Используем coroutines
//    suspend fun getProperties(@Query("name") type: String): List<ModelProperty>
    suspend fun getProperties(): List<ModelProperty>
}
*/

// Новый запрос
/*
interface MyService {
    @GET("character")
    suspend fun getProperties(): ModelResponse
}
*/


// Новый запрос c RxJava
interface MyService {
    @GET("character")
    fun getProperties(): Single<ModelResponse>
}


// инициализация службы Retrofit
object MyApi {
    val retrofitService: MyService by lazy {
        retrofit.create(MyService::class.java)
    }
}