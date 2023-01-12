package com.softsquared.template.kotlin.src.main.postadd.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.databinding.PostAddItemBinding
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddOneData
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddTwoData

class HomeAddOneAdapter(var homeAddList : List<HomeAddOneData>) : RecyclerView.Adapter<HomeAddOneAdapter.HomeAddViewHolder>() {


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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAddViewHolder {
        val binding =
            PostAddItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HomeAddViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeAddViewHolder, position: Int) {
        holder.bind(homeAddList[position])
        holder.itemView.setOnClickListener {
            itemClickListner.onClick(it, position)
            if(holder.binding.postImg.alpha == 0.7F) {
                holder.binding.postImg.alpha = 1F
            }else {
                holder.binding.postImg.alpha = 0.7F
            }

        }
    }
    override fun getItemCount(): Int = homeAddList.size

    inner class HomeAddViewHolder(val binding: PostAddItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: HomeAddOneData) {
            Glide.with(itemView).load(item.imgUrl).into(binding.postImg)
//            binding.postImg.setImageResource(R.drawable.ic_alarm_action)
        }

    }

}