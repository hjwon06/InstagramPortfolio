package com.softsquared.template.kotlin.src.main.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.HomePostItemBinding
import com.softsquared.template.kotlin.src.main.home.model.ResultData

class HomePostAdapter(var postList: List<ResultData>) : RecyclerView.Adapter<HomePostAdapter.PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding =
            HomePostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int = postList.size

    inner class PostViewHolder(private val binding: HomePostItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: ResultData?) {
//            binding.postWriterIcon.setImageResource(item!!.profileImgUrl as Int)
//            binding.postWriterName.text = item.nickName
//            binding.postContentsWriter.text = item.contents
//            binding.timeTxt.text = item.createdAt
        }
    }

}

