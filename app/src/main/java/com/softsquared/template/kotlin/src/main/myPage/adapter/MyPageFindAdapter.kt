package com.softsquared.template.kotlin.src.main.myPage.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.MypageFindItemBinding
import com.softsquared.template.kotlin.src.main.myPage.model.MyPageFindData

class MyPageFindAdapter (var findList: List<MyPageFindData>) : RecyclerView.Adapter<MyPageFindAdapter.FindViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FindViewHolder {
        val binding =
            MypageFindItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return FindViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FindViewHolder, position: Int) {
        holder.bind(findList[position])

    }

    override fun getItemCount(): Int = findList.size

    inner class FindViewHolder(private val binding: MypageFindItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: MyPageFindData) {
            binding.mpFindImg.setImageResource(item.findImg)
            binding.followName.text = item.findName
            binding.followTxt.text = item.findTxt
        }
    }

}