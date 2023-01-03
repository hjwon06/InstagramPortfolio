package com.softsquared.template.kotlin.src.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentHomeBinding
import com.softsquared.template.kotlin.src.main.home.adapter.HomePostAdapter
import com.softsquared.template.kotlin.src.main.home.adapter.HomeStoryAdapter
import com.softsquared.template.kotlin.src.main.home.model.HomePostItem
import com.softsquared.template.kotlin.src.main.home.model.HomeStoryItem

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home) {

    private var storyList = arrayListOf<HomeStoryItem>()
    private var postList = arrayListOf<HomePostItem>()
    private val storyAdapter = HomeStoryAdapter(storyList)
    private val postAdapter = HomePostAdapter(postList)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerviewControl()
    }


    private fun recyclerviewControl(){
        binding.storyList.apply{
            binding.storyList.adapter = storyAdapter
            for (i in 0..10) {
                storyList.add(HomeStoryItem(storyImg = "test", storyName = "riraviolin"))
            }
            setHasFixedSize(true)
        }


        binding.postList.apply{
            binding.postList.adapter = postAdapter
            for (i in 0..2) {
                postList.add(HomePostItem(nickName = "1", likeNickName = "1", postContents = "1", commentCnt = "1", timeTxt = "1"))
            }
            setHasFixedSize(true)
        }

    }
}