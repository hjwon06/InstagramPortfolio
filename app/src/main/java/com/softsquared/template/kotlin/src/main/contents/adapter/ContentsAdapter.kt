package com.softsquared.template.kotlin.src.main.contents.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.databinding.ContentsItemBinding
import com.softsquared.template.kotlin.src.main.contents.model.ContentsData

class ContentsAdapter (var items: List<ContentsData>) : RecyclerView.Adapter<ContentsAdapter.CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val binding =
            ContentsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class CommentViewHolder(private val binding: ContentsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ContentsData) {
            binding.contentsNick.text = item.nickName
            binding.contentsText.text = item.contents
            if(item.commentLikeCount!! > 0) {
                binding.contentsLikeCnt.text = item.commentLikeCount.toString()
            }else {
                binding.contentsLikeCnt.text = ""
            }
            binding.contentsTime.text = item.createdAt
            if(item.likeOrNot == "N") {
                binding.contentsLike.setImageResource(R.drawable.ic_alarm)
            }else {
                binding.contentsLike.setImageResource(R.drawable.ic_alarm_action)
            }

        }
    }
}