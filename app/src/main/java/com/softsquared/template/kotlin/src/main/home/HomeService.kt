package com.softsquared.template.kotlin.src.main.home

import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.home.model.HomeResponse
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
}