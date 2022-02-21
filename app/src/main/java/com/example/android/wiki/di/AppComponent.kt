package com.example.android.wiki.di

import android.content.Context
import com.example.android.wiki.detail.DetailFragment
import com.example.android.wiki.overview.OverviewFragment
import com.example.android.wiki.overview.OverviewViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

//@Singleton
@Component/*(modules = [NetworkModule::class])*/
interface AppComponent {

   /* // // Factory to create instances of AppComponent
    @Component.Factory
    interface Factory {
        fun create() : AppComponent
    }*/

    // получаем Context
    /*@Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context) : AppComponent
    }*/

//    fun inject(overviewViewModel: OverviewViewModel)

    /*@Component.Builder
    interface Builder {
        fun build() : AppComponent

        fun networkModule(networkModule: NetworkModule): Builder
    }*/

    fun inject(fragment : OverviewFragment)
    fun inject(fragment : DetailFragment)
}