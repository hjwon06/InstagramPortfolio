package com.softsquared.template.kotlin.src.main.home

import android.os.Bundle
import android.util.Log
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentHomeBinding
import com.softsquared.template.kotlin.src.main.home.adapter.HomePostAdapter
import com.softsquared.template.kotlin.src.main.home.adapter.HomeStoryAdapter
import com.softsquared.template.kotlin.src.main.home.model.HomeResponse
import com.softsquared.template.kotlin.src.main.home.model.HomeStoryData
import com.softsquared.template.kotlin.src.main.home.model.ResultData

@Suppress("UNCHECKED_CAST")
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home), HomeInterface {

    private var storyList = arrayListOf<HomeStoryData>()
//    private var postList = arrayListOf<ResultData>()
    private val storyAdapter = HomeStoryAdapter(storyList)
//    private val postAdapter = HomePostAdapter(postList)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Log.d("test",ApplicationClass.sSharedPreferences.getInt("userIdx", 0).toString())
        HomeService(this).tryGetPost(ApplicationClass.sSharedPreferences.getInt("userIdx", 0))
        recyclerviewControl()
    }


    private fun recyclerviewControl(){
        binding.storyList.apply{
            binding.storyList.adapter = storyAdapter
            storyList.add(HomeStoryData(storyImg = R.drawable.ic_my_story_add, storyName = "내 스토리"))
            for (i in 1..10) {
                storyList.add(HomeStoryData(storyImg = R.drawable.ic_home_story_icon, storyName = "riraviolin"))
            }
            setHasFixedSize(true)
        }

    }

    override fun onGetHomeSuccess(response: HomeResponse) {
        val homePostAdapter = HomePostAdapter(response.result as List<ResultData>)
        Log.d("----", "결과 : " + response.result.size)
        binding.postList.apply {
            binding.postList.adapter = homePostAdapter
            setHasFixedSize(true)
        }


//        Log.d("test1","test : " + response.result as List<ResultData>)

    }

    override fun onGetHomeFailure(message: String) {
        Log.d("test2",message)
    }
}