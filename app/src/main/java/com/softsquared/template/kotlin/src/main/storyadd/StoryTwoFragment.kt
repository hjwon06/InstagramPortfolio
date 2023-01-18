package com.softsquared.template.kotlin.src.main.storyadd

import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentStoryAddOneBinding
import com.softsquared.template.kotlin.databinding.FragmentStoryAddTwoBinding
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.main.home.HomeFragment
import com.softsquared.template.kotlin.src.main.storyadd.model.StoryAddData
import com.softsquared.template.kotlin.src.main.storyadd.model.StoryAddResponse

class StoryTwoFragment: BaseFragment<FragmentStoryAddTwoBinding>(FragmentStoryAddTwoBinding::bind, R.layout.fragment_story_add_two),StoryAddInterface {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userIdx = ApplicationClass.sSharedPreferences.getInt("userIdx", 0)
        val imgUrl = ApplicationClass.sSharedPreferences.getString("storyImg", "").toString()
        Glide.with(binding.root).load(imgUrl).into(binding.storyAddImg)

//        binding.storyAddImg.setImageResource(R.drawable.back_story)
        binding.storyBackBtn.setOnClickListener {
            parentFragmentManager.beginTransaction().remove(this).commit()
        }
        Log.d("test", "test : $imgUrl")

        binding.storyAddBtn.setOnClickListener {
            StoryAddService(this).tryPostAdd(StoryAddData(userIdx,imgUrl))

        }

    }

    override fun onPostAddSuccess(response: StoryAddResponse) {
        Log.d("test","test : " + response.result)
        val mainAct = activity as MainActivity
        parentFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commit()
        mainAct.bottomNavigationHide(false)
    }

    override fun onPostAddFailure(message: String) {
        TODO("Not yet implemented")
    }
}