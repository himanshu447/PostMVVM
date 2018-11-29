package com.example.applecustomer.postmvvm.view.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.applecustomer.postmvvm.R
import com.example.applecustomer.postmvvm.base.MyApplication
import com.example.applecustomer.postmvvm.databinding.ActivityMainBinding
import com.example.applecustomer.postmvvm.di.ViewModelFactory
import com.example.applecustomer.postmvvm.model.PostDataClass
import com.example.applecustomer.postmvvm.view.adapater.PostListAdapater
import com.example.applecustomer.postmvvm.viewmodel.PostListViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PostListViewModel
    private var erroSnackbar: Snackbar? = null

    @Inject
    lateinit var viewModeFactory: ViewModelFactory

    val postListAdapter: PostListAdapater = PostListAdapater()
    lateinit var data: MutableLiveData<List<PostDataClass>>


    override fun onCreate(savedInstanceState: Bundle?) {

        (application as MyApplication).component.inject(this)

        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.postListRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.postListRV.adapter = postListAdapter

        viewModel = ViewModelProviders.of(this, viewModeFactory).get(PostListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer { errormsg ->
            if (errormsg != null) showError(errormsg) else hideError()
        })
        viewModel.data.observe(this, Observer {

            if (it != null) {
                postListAdapter.updatePostList(it)
            }
        })
        binding.postViewModel = viewModel
    }

    private fun hideError() {
        erroSnackbar?.dismiss()
    }

    private fun showError(@StringRes errormsg: Int) {
        erroSnackbar = Snackbar.make(binding.root, errormsg, Snackbar.LENGTH_INDEFINITE)
        erroSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        erroSnackbar?.show()
    }


}
