package com.softsquared.template.kotlin.src.main.postadd

import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.sSharedPreferences
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentPostAddOneBinding
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.main.postadd.adapter.HomeAddOneAdapter
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddOneData

class PostAddOneFragment: BaseFragment<FragmentPostAddOneBinding>(FragmentPostAddOneBinding::bind, R.layout.fragment_post_add_one) {
    private var postAddList = arrayListOf<HomeAddOneData>()
    private val postAddAdapter = HomeAddOneAdapter(postAddList)
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
        val editor = sSharedPreferences.edit()
        Glide.with(binding.root).load("https://firebasestorage.googleapis.com/v0/b/fir-test-c1c89.appspot.com/o/2.jpg?alt=media&token=ad262090-84bf-4d68-8696-4ee0f80f4d38")
            .into(binding.postAddPic)
        binding.postCloseBtn.setOnClickListener {
            parentFragmentManager.beginTransaction().remove(this).commit()
            mainAct.bottomNavigationHide(false)
        }

        binding.postNextBtn.setOnClickListener {
            parentFragmentManager.beginTransaction().add(R.id.main_frm, PostAddTwoFragment()).commit()
        }

        postAddAdapter.setItemClickListener(object : HomeAddOneAdapter.ItemClickListener {
            override fun onClick(view: View, position: Int) {
                Log.d("test", "${position}번 리스트 선택")
                Glide.with(binding.root).load(postAddList[position].imgUrl).into(binding.postAddPic)
                editor.putString("imgUrl",postAddList[position].imgUrl)
                editor.apply()
            }
        })

        recyclerviewControl()
    }



    private fun recyclerviewControl() {
        binding.postAddList.apply {
            binding.postAddList.adapter = postAddAdapter
            for (i in imgUrlList.indices) {
                Log.d("test", "test")
                postAddList.add(HomeAddOneData(imgUrlList[i]))
                setHasFixedSize(true)
            }
        }
    }
}

