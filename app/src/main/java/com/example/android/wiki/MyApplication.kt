package com.example.android.wiki

import android.app.Application
import com.example.android.wiki.di.AppComponent
import com.example.android.wiki.di.DaggerAppComponent

//import com.example.android.wiki.di.DaggerAppComponent

open class MyApplication : Application() {

    val appComponent: AppComponent = DaggerAppComponent.create()
}