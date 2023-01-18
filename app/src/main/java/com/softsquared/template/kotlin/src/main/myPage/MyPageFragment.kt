package com.softsquared.template.kotlin.src.main.myPage

import android.os.Bundle
import android.util.Log
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentMypageBinding
import com.softsquared.template.kotlin.src.main.myPage.adapter.MyPageFindAdapter
import com.softsquared.template.kotlin.src.main.myPage.adapter.MyPageStoryAdapter
import com.softsquared.template.kotlin.src.main.myPage.adapter.MypageSliderAdapter
import com.softsquared.template.kotlin.src.main.myPage.model.MyPageFindData
import com.softsquared.template.kotlin.src.main.myPage.model.MyPageStoryData
import com.softsquared.template.kotlin.src.main.myPage.model.MyPageStoryResponse

class MyPageFragment: BaseFragment<FragmentMypageBinding>(FragmentMypageBinding::bind, R.layout.fragment_mypage),MyPageStoryInterface {
    private var findList = arrayListOf<MyPageFindData>()
    private var storyList = arrayListOf<MyPageStoryData>()
    private val findAdapter = MyPageFindAdapter(findList)
//    private val storyAdapter = MyPageStoryAdapter(storyList)
    private var viewBtnBool = false
    private var storyHrBool = false
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerviewControl()
        val userIdx = ApplicationClass.sSharedPreferences.getInt("userIdx",0)
        MyPageStoryService(this).tryPostContents(userIdx)
        binding.findViewBtn.setOnClickListener {
            if(!viewBtnBool) {
                binding.findViewBtn.setImageResource(R.drawable.ic_find_view_action_btn)
                binding.findViewLayout.visibility = View.VISIBLE
                viewBtnBool = true
            }else {
                binding.findViewBtn.setImageResource(R.drawable.ic_find_view_btn)
                binding.findViewLayout.visibility = View.GONE
                viewBtnBool = false
            }
        }

        binding.mpStoryBtn.setOnClickListener {
            if(!storyHrBool) {
                binding.mpStoryBtn.setImageResource(R.drawable.ic_mp_story_action_btn)
                binding.mpStroyList.visibility = View.VISIBLE
                storyHrBool = true
            }else {
                binding.mpStoryBtn.setImageResource(R.drawable.ic_mp_story_btn)
                binding.mpStroyList.visibility = View.GONE
                storyHrBool = false
            }
        }


    }


    private fun recyclerviewControl(){
        binding.mpFindPeopleList.apply{
            binding.mpFindPeopleList.adapter = findAdapter
            for (i in 0..10) {
                findList.add(MyPageFindData(R.drawable.ic_mp_find_img,"이름","회원님을 팔로우 합니다"))
            }
            setHasFixedSize(true)
        }

//        binding.mpStroyList.apply{
//            binding.mpStroyList.adapter = storyAdapter
//            storyList.add(MyPageStoryData("","","","","","",7 R.drawable.ic_stroy_hr_new_img,"신규"))
//            for (i in 0..10) {
//                storyList.add(MyPageStoryData(R.drawable.ic_story_hr_img,""))
//            }
//            setHasFixedSize(true)
//        }


    }

    override fun onGetMyPageStorySuccess(response: MyPageStoryResponse) {
        Log.d("test2","test : " + response.result)
        binding.mpStroyList.apply {
            binding.mpStroyList.adapter = MyPageStoryAdapter(response.result!!)
            Log.d("test","test : " + response.result)
            setHasFixedSize(true)

        }
    }

    override fun onGetMyPageStoryFailure(message: String) {
        Log.d("test2",message)
    }
}