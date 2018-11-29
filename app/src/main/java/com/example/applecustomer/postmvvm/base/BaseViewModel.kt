package com.example.applecustomer.postmvvm.base

import android.arch.lifecycle.ViewModel
abstract class BaseViewModel : ViewModel() {

   /* private val injector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when(this){
            is PostListViewModel -> injector.inject(this)
        }
    }*/


}