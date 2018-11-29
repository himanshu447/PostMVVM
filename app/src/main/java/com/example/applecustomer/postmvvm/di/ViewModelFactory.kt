package com.example.applecustomer.postmvvm.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.applecustomer.postmvvm.network.PostApi
import com.example.applecustomer.postmvvm.viewmodel.PostListViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val postApi: PostApi) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PostListViewModel(postApi) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}