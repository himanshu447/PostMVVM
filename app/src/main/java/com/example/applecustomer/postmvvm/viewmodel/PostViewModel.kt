package com.example.applecustomer.postmvvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.example.applecustomer.postmvvm.base.BaseViewModel
import com.example.applecustomer.postmvvm.model.PostDataClass
import retrofit2.http.POST

class PostViewModel : BaseViewModel() {

    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: PostDataClass) {
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle():MutableLiveData<String>{
        return postTitle
    }

    fun getPostBody():MutableLiveData<String>{
        return  postBody
    }
}