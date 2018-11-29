package com.example.applecustomer.postmvvm.network
import com.example.applecustomer.postmvvm.model.PostDataClass
import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi {

    @GET("/posts")
    fun getPosts() : Observable<List<PostDataClass>>
}