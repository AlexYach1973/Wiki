package com.example.android.wiki.di

import com.example.android.wiki.detail.DetailFragment
import com.example.android.wiki.overview.OverviewFragment
import dagger.Component
import javax.inject.Singleton

//@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {

    fun inject(fragment : OverviewFragment)
    fun inject(fragment : DetailFragment)
}