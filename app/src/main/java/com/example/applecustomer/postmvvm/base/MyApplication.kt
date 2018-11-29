package com.example.applecustomer.postmvvm.base

import android.app.Application
import com.example.applecustomer.postmvvm.di.component.DaggerViewModelInjector
import com.example.applecustomer.postmvvm.di.component.ViewModelInjector
import com.example.applecustomer.postmvvm.di.module.ApplicationModule
import com.example.applecustomer.postmvvm.di.module.NetworkModule

class MyApplication :Application() {

    lateinit var component:ViewModelInjector

    override fun onCreate() {
        super.onCreate()

        component = DaggerViewModelInjector
            .builder()
            .applicationModule(ApplicationModule(this))
            .networkModule(NetworkModule)
            .build()
    }
}