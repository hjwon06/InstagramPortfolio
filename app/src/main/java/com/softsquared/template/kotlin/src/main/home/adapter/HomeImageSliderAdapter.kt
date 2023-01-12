package com.softsquared.template.kotlin.src.main.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.databinding.HomePostImgSliderBinding
import com.softsquared.template.kotlin.src.main.home.model.Img

class HomeImageSliderAdapter(var items: List<Img>) : RecyclerView.Adapter<HomeImageSliderAdapter.PostViewHolder>()  {

//    private lateinit var items: ArrayList<String>
//
//    fun build(i: String?): HomeImageSliderAdapter {
//        items = i
//        return this
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding =
            HomePostImgSliderBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class PostViewHolder(private val binding: HomePostImgSliderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Img) {
            Glide.with(itemView).load(item.imgUrl).
            error("https://firebasestorage.googleapis.com/v0/b/fir-test-c1c89.appspot.com/o/2.jpg?alt=media&token=ad262090-84bf-4d68-8696-4ee0f80f4d38").
            into(binding.homePostImg)
        }
    }
}