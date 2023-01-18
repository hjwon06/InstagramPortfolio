package com.softsquared.template.kotlin.src.main.home

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.home.adapter.HomePostAdapter
import com.softsquared.template.kotlin.src.main.home.model.HomeDeleteResponse
import com.softsquared.template.kotlin.src.main.home.model.HomeLikeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeDeleteService(val homeInterface: HomeDeleteInterface)  {

    //게시글 보이기
    fun tryPatchDelete(userIdx : Int,postIdx : Int){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.patchDelete(userIdx,postIdx).enqueue(object : Callback<HomeDeleteResponse> {
            override fun onResponse(call: Call<HomeDeleteResponse>, response: Response<HomeDeleteResponse>) {
                homeInterface.onPatchHomeDeleteSuccess(response.body() as HomeDeleteResponse)

            }

            override fun onFailure(call: Call<HomeDeleteResponse>, t: Throwable) {
                homeInterface.onPatchHomeDeleteFailure(t.message ?: "통신 오류")
            }
        })
    }
}