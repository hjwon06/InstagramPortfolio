package com.softsquared.template.kotlin.src.main.storyadd.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.databinding.PostAddItemBinding
import com.softsquared.template.kotlin.databinding.StoryAddListItemBinding
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddOneData
import com.softsquared.template.kotlin.src.main.storyadd.model.StoryOneData

class StoryOneAdapter (var storyAddList : List<StoryOneData>) : RecyclerView.Adapter<StoryOneAdapter.StoryAddViewHolder>() {


    //클릭 인터페이스 정의
    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    //클릭리스너 선언
    private lateinit var itemClickListner: ItemClickListener

    //클릭리스너 등록 매소드
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListner = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryAddViewHolder {
        val binding =
            StoryAddListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return StoryAddViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryAddViewHolder, position: Int) {
        holder.bind(storyAddList[position])
        holder.itemView.setOnClickListener {
            itemClickListner.onClick(it, position)

        }
    }
    override fun getItemCount(): Int = storyAddList.size

    inner class StoryAddViewHolder(val binding: StoryAddListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: StoryOneData) {
            Glide.with(itemView).load(item.imgUrl).into(binding.storyAddItemImg)
//            binding.postImg.setImageResource(R.drawable.ic_alarm_action)
        }

    }

}