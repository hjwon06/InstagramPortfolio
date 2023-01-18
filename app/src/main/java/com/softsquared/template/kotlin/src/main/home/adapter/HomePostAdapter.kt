package com.softsquared.template.kotlin.src.main.home.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.databinding.HomePostItemBinding
import com.softsquared.template.kotlin.src.ClickListner
import com.softsquared.template.kotlin.src.main.home.HomeLikeInterface
import com.softsquared.template.kotlin.src.main.home.HomeLikeService
import com.softsquared.template.kotlin.src.main.home.model.HomeLikeResponse
import com.softsquared.template.kotlin.src.main.home.model.Img
import com.softsquared.template.kotlin.src.main.home.model.ResultData


class HomePostAdapter(var postList: List<ResultData>, private val clickListner: ClickListner?) : RecyclerView.Adapter<HomePostAdapter.PostViewHolder>(), HomeLikeInterface{



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding =
            HomePostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
        val editor = ApplicationClass.sSharedPreferences.edit()

        holder.binding.postLikeBtn.setOnClickListener {
            Log.d("test","test : " + Integer.parseInt(holder.binding.postIdx.text as String))
            val postIdx = holder.binding.postIdx.text
            HomeLikeService(this).tryPostLike(ApplicationClass.sSharedPreferences.getInt("userIdx", 0),
            Integer.parseInt(postIdx as String))
            if(!ApplicationClass.sSharedPreferences.getBoolean("like", false)) {
                holder.binding.postLikeBtn.setImageResource(R.drawable.ic_alarm)
            }else {
                holder.binding.postLikeBtn.setImageResource(R.drawable.ic_alarm_action)
            }
        }

        holder.binding.commentSeeBtn.setOnClickListener {

            editor.putInt("postIdx", Integer.parseInt(holder.binding.postIdx.text as String))
            editor.apply()
            Log.d("test","test : " + ApplicationClass.sSharedPreferences.getInt("postIdx",0))
            clickListner?.onViewClick(holder.binding,position)
        }


        holder.binding.postSetting.setOnClickListener {
            Log.d("test","test1")
            editor.putInt("postIdx", Integer.parseInt(holder.binding.postIdx.text as String))
            clickListner?.onDeleteClick(it,position)
        }
    }

    override fun getItemCount(): Int = postList.size

    inner class PostViewHolder(val binding: HomePostItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: ResultData) {
            binding.postIdx.text = item.postIdx.toString()
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

    override fun onPostHomeLikeSuccess(response: HomeLikeResponse) {
        val editor = ApplicationClass.sSharedPreferences.edit()

        if(response.result == "좋아요") {
            editor.putBoolean("like",true)
        }else if((response.result == "좋아요 취소")){
            editor.putBoolean("like",false)
        }
        editor.apply()
    }



    override fun onPostHomeLikeFailure(message: String) {
        Log.d("test", "test : $message")
    }

}



