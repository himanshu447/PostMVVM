package com.example.applecustomer.postmvvm.view.adapater

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.applecustomer.postmvvm.R
import com.example.applecustomer.postmvvm.databinding.ItemPostBinding
import com.example.applecustomer.postmvvm.model.PostDataClass
import com.example.applecustomer.postmvvm.viewmodel.PostViewModel

class PostListAdapater : RecyclerView.Adapter<PostListAdapater.PostListVH>() {

    private lateinit var postList: List<PostDataClass>

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PostListVH {
        val binding: ItemPostBinding =
            DataBindingUtil.inflate(LayoutInflater.from(p0.context), R.layout.item_post, p0, false)

        return PostListVH(binding)
    }

    override fun getItemCount(): Int {
        return if (::postList.isInitialized) postList.size else 0
    }

    override fun onBindViewHolder(p0: PostListVH, p1: Int) {
        p0.bind(postList[p1])
    }

    fun updatePostList(it: List<PostDataClass>) {
        this.postList = it
        notifyDataSetChanged()
    }


    class PostListVH(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {

        private val viewModel = PostViewModel()

        fun bind(postDataClass: PostDataClass) {
            viewModel.bind(postDataClass)
            binding.postViewModel = viewModel
        }

    }
}