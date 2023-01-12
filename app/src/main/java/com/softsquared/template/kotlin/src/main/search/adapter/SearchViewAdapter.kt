package com.softsquared.template.kotlin.src.main.search.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.databinding.MypageFindItemBinding
import com.softsquared.template.kotlin.databinding.MypageStoryItemBinding
import com.softsquared.template.kotlin.databinding.SearchViewItemBinding
import com.softsquared.template.kotlin.src.main.myPage.model.MyPageFindData
import com.softsquared.template.kotlin.src.main.myPage.model.MyPageStoryData
import com.softsquared.template.kotlin.src.main.search.model.SearchData
import com.softsquared.template.kotlin.src.main.search.model.SearchViewData

class SearchViewAdapter (var searchList: List<SearchData>) : RecyclerView.Adapter<SearchViewAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding =
            SearchViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(searchList[position])
        Log.d("test","test : " + searchList.size)
    }

    override fun getItemCount(): Int = searchList.size

    inner class SearchViewHolder(val binding: SearchViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: SearchData) {
//            binding.searchImg.setImageResource(R.drawable.ic_search_img)
            Glide.with(itemView).load(item.imgUrl).
            error("https://firebasestorage.googleapis.com/v0/b/fir-test-c1c89.appspot.com/o/2.jpg?alt=media&token=ad262090-84bf-4d68-8696-4ee0f80f4d38").
            into(binding.searchImg)
        }
    }

}