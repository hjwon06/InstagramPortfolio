package com.softsquared.template.kotlin.src.main.home.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.circleCrop
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.databinding.HomePostItemBinding
import com.softsquared.template.kotlin.databinding.HomeStoryItemBinding
import com.softsquared.template.kotlin.src.ClickListner
import com.softsquared.template.kotlin.src.main.home.model.HomeStoryData

class HomeStoryAdapter (var storyList: List<HomeStoryData>, private val clickListner: ClickListner?) : RecyclerView.Adapter<HomeStoryAdapter.StoryViewHolder>() {

    //클릭 인터페이스 정의
    interface ItemClickListener {
        fun onClick(view: HomeStoryItemBinding, position: Int)
    }

    //클릭리스너 선언
    private lateinit var itemClickListner: ItemClickListener

    //클릭리스너 등록 매소드
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListner = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val binding =
            HomeStoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        if(position >= 1) {
            holder.bind(storyList[position])
        }else if(position == 0) {
            holder.binding.homeStoryName.text = "내 스토리"
            holder.binding.homeStoryIcon.setImageResource(R.drawable.ic_my_story_add)
        }
        holder.binding.homeStoryIcon.setOnClickListener {
            clickListner?.onStoryClick(holder.binding,position)
        }

    }

    override fun getItemCount(): Int = storyList.size

    inner class StoryViewHolder(val binding: HomeStoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: HomeStoryData) {
            binding.homeStoryName.text = item.nickName
            Glide.with(itemView).load(item.imageURL).
            circleCrop().
            centerInside().
            error("https://firebasestorage.googleapis.com/v0/b/fir-test-c1c89.appspot.com/o/2.jpg?alt=media&token=ad262090-84bf-4d68-8696-4ee0f80f4d38").
            into(binding.homeStoryIcon)
        }

    }

}