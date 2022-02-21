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
//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()


// Создание объекта Retrofit
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
//    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()

// Интерфейс c использованием RxJava
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