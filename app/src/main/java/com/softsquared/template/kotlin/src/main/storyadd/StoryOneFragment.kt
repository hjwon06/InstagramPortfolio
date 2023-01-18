package com.softsquared.template.kotlin.src.main.storyadd

import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentStoryAddOneBinding
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.main.postadd.PostAddOneFragment
import com.softsquared.template.kotlin.src.main.postadd.adapter.HomeAddOneAdapter
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddOneData
import com.softsquared.template.kotlin.src.main.storyadd.adapter.StoryOneAdapter
import com.softsquared.template.kotlin.src.main.storyadd.model.StoryOneData

class StoryOneFragment: BaseFragment<FragmentStoryAddOneBinding>(FragmentStoryAddOneBinding::bind, R.layout.fragment_story_add_one) {
    private var storyAddList = arrayListOf<StoryOneData>()
    private val storyAddAdapter = StoryOneAdapter(storyAddList)
    var imgUrlList : List<String> = listOf("https://firebasestorage.googleapis.com/v0/b/fir-test-c1c89.appspot.com/o/2.jpg?alt=media&token=ad262090-84bf-4d68-8696-4ee0f80f4d38",
        "https://firebasestorage.googleapis.com/v0/b/fir-test-c1c89.appspot.com/o/c5.jpeg?alt=media&token=2e0488ce-087d-4033-a7d8-7ce9ce1531da",
        "https://firebasestorage.googleapis.com/v0/b/fir-test-c1c89.appspot.com/o/2.jpg?alt=media&token=ad262090-84bf-4d68-8696-4ee0f80f4d38",
        "https://firebasestorage.googleapis.com/v0/b/fir-test-c1c89.appspot.com/o/2.jpg?alt=media&token=ad262090-84bf-4d68-8696-4ee0f80f4d38",
        "https://firebasestorage.googleapis.com/v0/b/fir-test-c1c89.appspot.com/o/2.jpg?alt=media&token=ad262090-84bf-4d68-8696-4ee0f80f4d38",
        "https://firebasestorage.googleapis.com/v0/b/fir-test-c1c89.appspot.com/o/2.jpg?alt=media&token=ad262090-84bf-4d68-8696-4ee0f80f4d38",
        "https://firebasestorage.googleapis.com/v0/b/fir-test-c1c89.appspot.com/o/2.jpg?alt=media&token=ad262090-84bf-4d68-8696-4ee0f80f4d38",
        "https://firebasestorage.googleapis.com/v0/b/fir-test-c1c89.appspot.com/o/2.jpg?alt=media&token=ad262090-84bf-4d68-8696-4ee0f80f4d38",
        "https://firebasestorage.googleapis.com/v0/b/fir-test-c1c89.appspot.com/o/2.jpg?alt=media&token=ad262090-84bf-4d68-8696-4ee0f80f4d38",
        "https://firebasestorage.googleapis.com/v0/b/fir-test-c1c89.appspot.com/o/2.jpg?alt=media&token=ad262090-84bf-4d68-8696-4ee0f80f4d38",)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainAct = activity as MainActivity
        mainAct.bottomNavigationHide(true)
        val editor = ApplicationClass.sSharedPreferences.edit()
        binding.storyBackBtn.setOnClickListener {
            parentFragmentManager.beginTransaction().remove(this).commit()
            mainAct.bottomNavigationHide(false)
        }
        recyclerviewControl()

        storyAddAdapter.setItemClickListener( object : StoryOneAdapter.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                editor.putString("storyImg",storyAddList[position].imgUrl)
                editor.apply()
                parentFragmentManager.beginTransaction().add(R.id.main_frm, StoryTwoFragment()).commit()
            }
        })

    }

    private fun recyclerviewControl() {
        binding.storyAddList.apply {
            binding.storyAddList.adapter = storyAddAdapter
            for (i in imgUrlList.indices) {
                Log.d("test", "test")
                storyAddList.add(StoryOneData(imgUrlList[i]))
                setHasFixedSize(true)
            }
        }
    }
}