package com.example.applecustomer.postmvvm.di.module

import android.app.Application
import android.content.Context
import com.example.applecustomer.postmvvm.di.ViewModelFactory
import com.example.applecustomer.postmvvm.network.PostApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ApplicationModule internal constructor(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplicationContext():Context{
        return application
    }

    @Provides
    fun provideViewModelFactory(postApi: PostApi) :ViewModelFactory{
        return ViewModelFactory(postApi)
    }
}