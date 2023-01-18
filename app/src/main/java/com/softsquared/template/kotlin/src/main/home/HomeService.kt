package com.softsquared.template.kotlin.src.main.home

import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.home.model.HomeResponse
import com.softsquared.template.kotlin.src.main.home.model.HomeStroyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeService(val homeInterface: HomeInterface)  {

    //게시글 보이기
    fun tryGetPost(idx : Int){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.getPost(idx).enqueue(object : Callback<HomeResponse> {
            override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {
                homeInterface.onGetHomeSuccess(response.body() as HomeResponse)

            }

            override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                homeInterface.onGetHomeFailure(t.message ?: "통신 오류")
            }
        })
    }

    //팔로우스토리 보이기
    fun tryGetStory(idx : Int){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.getStory(idx).enqueue(object : Callback<HomeStroyResponse> {
            override fun onResponse(call: Call<HomeStroyResponse>, response: Response<HomeStroyResponse>) {
                homeInterface.onGetHomeStorySuccess(response.body() as HomeStroyResponse)

            }

            override fun onFailure(call: Call<HomeStroyResponse>, t: Throwable) {
                homeInterface.onGetHomeStoryFailure(t.message ?: "통신 오류")
            }
        })
    }
}