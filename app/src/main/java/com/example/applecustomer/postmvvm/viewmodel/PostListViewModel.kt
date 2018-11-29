package com.example.applecustomer.postmvvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import android.view.View
import com.example.applecustomer.postmvvm.R
import com.example.applecustomer.postmvvm.base.BaseViewModel
import com.example.applecustomer.postmvvm.model.PostDataClass
import com.example.applecustomer.postmvvm.network.PostApi
import com.example.applecustomer.postmvvm.view.adapater.PostListAdapater
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostListViewModel(private val postApi: PostApi) : BaseViewModel() {

    private lateinit var subscription: Disposable

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    var errorClickListener = View.OnClickListener { loadPosts() }

    var data: MutableLiveData<List<PostDataClass>> = MutableLiveData()


    init {
        loadPosts()
    }

    private fun loadPosts() {
        subscription = postApi.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe({
                onRetrievePostListSuccess(it)
            }, {
                onRetrievePostListError()
            })
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE

    }

    private fun onRetrievePostListSuccess(it: List<PostDataClass>) {
        data.value=it
    }

    private fun onRetrievePostListError() {
        errorMessage.value = R.string.post_error
    }


}