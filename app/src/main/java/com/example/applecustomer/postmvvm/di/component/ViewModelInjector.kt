package com.example.applecustomer.postmvvm.di.component

import com.example.applecustomer.postmvvm.di.module.ApplicationModule
import com.example.applecustomer.postmvvm.di.module.NetworkModule
import com.example.applecustomer.postmvvm.view.ui.MainActivity
import com.example.applecustomer.postmvvm.viewmodel.PostListViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [(NetworkModule::class),(ApplicationModule::class)])
interface ViewModelInjector {


    fun inject(mainActivity: MainActivity)

    //fun inject(pstListViewModel: PostListViewModel)



    /*@Component.Builder
    interface Builder{

        fun build() : ViewModelInjector

        fun networkModule(networkModule: NetworkModule) : Builder
    }*/
}