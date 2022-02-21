package com.example.android.wiki

import android.app.Application
import com.example.android.wiki.di.AppComponent
import com.example.android.wiki.di.DaggerAppComponent

open class MyApplication : Application() {

    // Экземпляр AppComponent, который будет везде использоваться
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.create()
    }
}