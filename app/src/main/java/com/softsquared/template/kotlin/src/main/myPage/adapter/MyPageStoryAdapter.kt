package com.softsquared.template.kotlin.src.main.myPage.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.databinding.MypageFindItemBinding
import com.softsquared.template.kotlin.databinding.MypageStoryItemBinding
import com.softsquared.template.kotlin.src.main.myPage.model.MyPageFindData
import com.softsquared.template.kotlin.src.main.myPage.model.MyPageStoryData

class MyPageStoryAdapter (var storyList: MyPageStoryData) : RecyclerView.Adapter<MyPageStoryAdapter.MyPageStoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPageStoryViewHolder {
        val binding =
            MypageStoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyPageStoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyPageStoryViewHolder, position: Int) {
        holder.bind(storyList)

    }

    override fun getItemCount(): Int = storyList.storyList!!.size

    inner class MyPageStoryViewHolder(private val binding: MypageStoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: MyPageStoryData) {
            if(item.nickName == "") {
                binding.mpStoryTxt.text = "test123"
            }else {
                binding.mpStoryTxt.text = item.nickName
            }

            Glide.with(itemView).load(item.imageURL).
            centerInside().
            circleCrop().
            error("https://firebasestorage.googleapis.com/v0/b/fir-test-c1c89.appspot.com/o/2.jpg?alt=media&token=ad262090-84bf-4d68-8696-4ee0f80f4d38").
            into(binding.mpStoryHrImg)

        }
    }

}