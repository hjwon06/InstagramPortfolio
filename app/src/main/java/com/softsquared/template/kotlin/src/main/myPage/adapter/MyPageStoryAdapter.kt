package com.softsquared.template.kotlin.src.main.myPage.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.MypageFindItemBinding
import com.softsquared.template.kotlin.databinding.MypageStoryItemBinding
import com.softsquared.template.kotlin.src.main.myPage.model.MyPageFindData
import com.softsquared.template.kotlin.src.main.myPage.model.MyPageStoryData

class MyPageStoryAdapter (var storyList: List<MyPageStoryData>) : RecyclerView.Adapter<MyPageStoryAdapter.FindViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FindViewHolder {
        val binding =
            MypageStoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return FindViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FindViewHolder, position: Int) {
        holder.bind(storyList[position])

    }

    override fun getItemCount(): Int = storyList.size

    inner class FindViewHolder(private val binding: MypageStoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: MyPageStoryData) {
            binding.mpStoryHrImg.setImageResource(item.storyImg)
            binding.mpStoryTxt.text = item.storyName
        }
    }

}