package com.softsquared.template.kotlin.src.main.home

import android.os.Bundle
import android.util.Log
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentHomeBinding
import com.softsquared.template.kotlin.databinding.HomePostItemBinding
import com.softsquared.template.kotlin.databinding.HomeStoryItemBinding
import com.softsquared.template.kotlin.src.ClickListner
import com.softsquared.template.kotlin.src.main.contents.ContentsFragment
import com.softsquared.template.kotlin.src.main.home.adapter.HomePostAdapter
import com.softsquared.template.kotlin.src.main.home.adapter.HomeStoryAdapter
import com.softsquared.template.kotlin.src.main.home.model.*
import com.softsquared.template.kotlin.src.main.postadd.PostAddOneFragment
import com.softsquared.template.kotlin.src.main.storyadd.StoryOneFragment
import com.softsquared.template.kotlin.util.PostDeleteDialog

@Suppress("UNCHECKED_CAST")
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home), HomeInterface {
    private var postList = arrayListOf<ResultData>()
    private val postAdapter = HomePostAdapter(postList,null)

    private var storyList = arrayListOf<HomeStoryData>()
    private val storyAdapter = HomeStoryAdapter(storyList,null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Log.d("test",ApplicationClass.sSharedPreferences.getInt("userIdx", 0).toString())
        HomeService(this).tryGetPost(ApplicationClass.sSharedPreferences.getInt("userIdx", 0))
        HomeService(this).tryGetStory(ApplicationClass.sSharedPreferences.getInt("userIdx", 0))
        binding.homeAddPost.setOnClickListener {
            parentFragmentManager.beginTransaction().add(R.id.main_frm, PostAddOneFragment()).commit()
        }

        binding.postList.apply{
            binding.postList.adapter = postAdapter
            for (i in 0..10) {
                postList.add(ResultData(3,"ㅎㅇ","3일 전", listOf(Img(7,"https://firebasestorage.googleapis.com/v0/b/fir-test-c1c89.appspot.com/o/2.jpg?alt=media&token=ad262090-84bf-4d68-8696-4ee0f80f4d38")
                ,Img(7,"https://firebasestorage.googleapis.com/v0/b/fir-test-c1c89.appspot.com/o/2.jpg?alt=media&token=ad262090-84bf-4d68-8696-4ee0f80f4d38")),
                    "N","dddd",17,3,
                null,7))
            }
            setHasFixedSize(true)
        }

        binding.storyList.apply {
            binding.storyList.adapter = storyAdapter
            for (i in 0..10) {
              storyList.add(HomeStoryData("","https://firebasestorage.googleapis.com/v0/b/fir-test-c1c89.appspot.com/o/2.jpg?alt=media&token=ad262090-84bf-4d68-8696-4ee0f80f4d38",
                  "ddt" + i,0,"N", listOf(7),7))
            }
        }
    }


    override fun onGetHomeSuccess(response: HomeResponse) {

        Log.d("----", "결과 : " + response.result.size)
        binding.postList.apply {
            binding.postList.adapter = HomePostAdapter(response.result as List<ResultData>, object : ClickListner{
                override fun onViewClick(view: HomePostItemBinding, position: Int) {
                    parentFragmentManager.beginTransaction().add(R.id.main_frm, ContentsFragment()).commit()
                }

                override fun onStoryClick(view: HomeStoryItemBinding, position: Int) {
                    TODO("Not yet implemented")
                }

                override fun onDeleteClick(view: View, position: Int) {
                    val postDeleteDialog = PostDeleteDialog(view.context)
                    postDeleteDialog.show()
                }
            })
//            binding.postList.adapter = homePostAdapter

            setHasFixedSize(true)
        }
//        Log.d("test1","test : " + response.result as List<ResultData>)

    }

    override fun onGetHomeFailure(message: String) {

    }

    override fun onGetHomeStorySuccess(response: HomeStroyResponse) {
        binding.storyList.apply{
            binding.storyList.adapter = HomeStoryAdapter(response.result as List<HomeStoryData>, object : ClickListner{
                override fun onViewClick(view: HomePostItemBinding, position: Int) {
                    TODO("Not yet implemented")
                }

                override fun onStoryClick(view: HomeStoryItemBinding, position: Int) {
                    if(position == 0) {
                        parentFragmentManager.beginTransaction().add(R.id.main_frm, StoryOneFragment()).commit()
                    }
                }

                override fun onDeleteClick(view: View, position: Int) {

                }

            })
            setHasFixedSize(true)
        }
    }

    override fun onGetHomeStoryFailure(message: String) {
        Log.d("test2",message)
    }
}