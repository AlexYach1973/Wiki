package com.example.android.wiki.network

import io.reactivex.Single
import retrofit2.http.GET

// Интерфейс c использованием RxJava

interface MyService {
    @GET("character")
    fun getProperties(): Single<ModelResponse>
}
