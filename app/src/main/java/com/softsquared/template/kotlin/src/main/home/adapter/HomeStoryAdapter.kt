package com.softsquared.template.kotlin.src.main.home.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.HomeStoryItemBinding
import com.softsquared.template.kotlin.src.main.home.model.HomeStoryData

class HomeStoryAdapter (var storyList: List<HomeStoryData>) : RecyclerView.Adapter<HomeStoryAdapter.StoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val binding =
            HomeStoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return StoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.bind(storyList[position])

    }

    override fun getItemCount(): Int = storyList.size

    inner class StoryViewHolder(private val binding: HomeStoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: HomeStoryData) {
            binding.homeStoryName.text = item.storyName
            binding.homeStoryIcon.setImageResource(item.storyImg)
        }

    }

}