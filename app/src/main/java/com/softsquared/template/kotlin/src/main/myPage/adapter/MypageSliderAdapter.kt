package com.softsquared.template.kotlin.src.main.myPage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.databinding.MypageImgSliderBinding
import com.softsquared.template.kotlin.src.main.home.model.Img

class MypageSliderAdapter(var items: ArrayList<Int>) : RecyclerView.Adapter<MypageSliderAdapter.PostViewHolder>()  {

//    private lateinit var items: ArrayList<String>
//
//    fun build(i: String?): HomeImageSliderAdapter {
//        items = i
//        return this
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding =
            MypageImgSliderBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class PostViewHolder(private val binding: MypageImgSliderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Int) {
//            binding.mypageImg.
        }
    }
}