package com.softsquared.template.kotlin.src.main.myPage

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.contents.model.ContentsData
import com.softsquared.template.kotlin.src.main.contents.model.ContentsPostData
import com.softsquared.template.kotlin.src.main.contents.model.ContentsPostResponse
import com.softsquared.template.kotlin.src.main.contents.model.ContentsResponse
import com.softsquared.template.kotlin.src.main.myPage.model.MyPageStoryResponse
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddTwoData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPageStoryService(val homeInterface: MyPageStoryInterface)  {

    //스토리 불러오기
    fun tryPostContents(userIdx : Int){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(MyPageStoryRetrofitInterface::class.java)
        homeRetrofitInterface.getStory(userIdx).enqueue(object : Callback<MyPageStoryResponse> {
            override fun onResponse(call: Call<MyPageStoryResponse>, response: Response<MyPageStoryResponse>) {
                homeInterface.onGetMyPageStorySuccess(response.body() as MyPageStoryResponse)

            }

            override fun onFailure(call: Call<MyPageStoryResponse>, t: Throwable) {
                homeInterface.onGetMyPageStoryFailure(t.message ?: "통신 오류")
            }
        })
    }

}