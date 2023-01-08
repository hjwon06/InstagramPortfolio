package com.softsquared.template.kotlin.src.main.search.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.MypageFindItemBinding
import com.softsquared.template.kotlin.databinding.MypageStoryItemBinding
import com.softsquared.template.kotlin.databinding.SearchViewItemBinding
import com.softsquared.template.kotlin.src.main.myPage.model.MyPageFindData
import com.softsquared.template.kotlin.src.main.myPage.model.MyPageStoryData
import com.softsquared.template.kotlin.src.main.search.model.SearchViewData

class SearchViewAdapter (var searchList: List<SearchViewData>) : RecyclerView.Adapter<SearchViewAdapter.searchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): searchViewHolder {
        val binding =
            SearchViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return searchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: searchViewHolder, position: Int) {
        holder.bind(searchList[position])

    }

    override fun getItemCount(): Int = searchList.size

    inner class searchViewHolder(private val binding: SearchViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: SearchViewData) {
            binding.pictures.setImageResource(item.pictures)
            binding.searchImg.setImageResource(item.searchImg)
        }
    }

}