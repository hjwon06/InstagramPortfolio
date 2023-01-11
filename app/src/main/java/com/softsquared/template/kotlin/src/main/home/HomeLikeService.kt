package com.softsquared.template.kotlin.src.main.home

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.home.adapter.HomePostAdapter
import com.softsquared.template.kotlin.src.main.home.model.HomeLikeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeLikeService(val homeInterface: HomeLikeInterface)  {

    //게시글 보이기
    fun tryPostLike(userIdx : Int,postIdx : Int){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.postLike(userIdx,postIdx).enqueue(object : Callback<HomeLikeResponse> {
            override fun onResponse(call: Call<HomeLikeResponse>, response: Response<HomeLikeResponse>) {
                homeInterface.onPostHomeLikeSuccess(response.body() as HomeLikeResponse)

            }

            override fun onFailure(call: Call<HomeLikeResponse>, t: Throwable) {
                homeInterface.onPostHomeLikeFailure(t.message ?: "통신 오류")
            }
        })
    }
}