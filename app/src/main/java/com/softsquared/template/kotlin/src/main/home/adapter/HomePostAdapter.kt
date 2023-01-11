package com.softsquared.template.kotlin.src.main.home.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.HomePostItemBinding
import com.softsquared.template.kotlin.src.main.home.model.Img
import com.softsquared.template.kotlin.src.main.home.model.ResultData

class HomePostAdapter(var postList: List<ResultData>) : RecyclerView.Adapter<HomePostAdapter.PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding =
            HomePostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
        Log.d("test","결과1 : " + position)

    }

    override fun getItemCount(): Int = postList.size

    inner class PostViewHolder(val binding: HomePostItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: ResultData) {
            Log.d("test","결과2: " + postList.size)
//            binding.postWriterIcon.setImageResource(item?.profileImgUrl as Int)
            binding.postWriterName.text = item.nickName
            binding.postContentsWriter.text = item.contents
            binding.timeTxt.text = item.createdAt
            if(item.commentCount!! > 0) {
                binding.commentSeeBtn.text = "댓글 " + item.commentCount + "개 모두보기"
            }else {
                binding.commentSeeBtn.text = "댓글 보기"
            }
            if(item.postLikeCount!! > 0) {
                binding.likeCntTxt.text = "좋아요 " + item.postLikeCount + "개"
            }else {
                binding.likeCntTxt.text = "좋아요 0 개"
            }
            binding.postPicture.adapter = HomeImageSliderAdapter(item.imgs as List<Img>)

        }
    }

}

