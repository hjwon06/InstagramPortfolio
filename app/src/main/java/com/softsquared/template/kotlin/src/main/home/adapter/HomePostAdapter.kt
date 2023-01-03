package com.softsquared.template.kotlin.src.main.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.HomePostItemBinding
import com.softsquared.template.kotlin.databinding.HomeStoryItemBinding
import com.softsquared.template.kotlin.src.main.home.model.HomePostItem
import com.softsquared.template.kotlin.src.main.home.model.HomeStoryItem

class HomePostAdapter (var storyList: List<HomePostItem>) : RecyclerView.Adapter<HomePostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding =
            HomePostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(storyList[position])
    }

    override fun getItemCount(): Int = storyList.size

    inner class PostViewHolder(private val binding: HomePostItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: HomePostItem) {
//            binding.homeStoryName.text = item.storyName
        }
    }

}