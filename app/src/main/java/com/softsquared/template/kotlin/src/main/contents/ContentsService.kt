package com.softsquared.template.kotlin.src.main.contents

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.contents.model.ContentsData
import com.softsquared.template.kotlin.src.main.contents.model.ContentsPostData
import com.softsquared.template.kotlin.src.main.contents.model.ContentsPostResponse
import com.softsquared.template.kotlin.src.main.contents.model.ContentsResponse
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddTwoData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContentsService(val homeInterface: ContentsInterface)  {

    //게시글 보이기
    fun tryPostContents(userIdx : Int,postIdx : Int){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(ContentsRetrofitInterface::class.java)
        homeRetrofitInterface.getComment(userIdx,postIdx).enqueue(object : Callback<ContentsResponse> {
            override fun onResponse(call: Call<ContentsResponse>, response: Response<ContentsResponse>) {
                homeInterface.onGetCommentSuccess(response.body() as ContentsResponse)

            }

            override fun onFailure(call: Call<ContentsResponse>, t: Throwable) {
                homeInterface.onGetCommentFailure(t.message ?: "통신 오류")
            }
        })
    }

    //게시글 등록하기
    fun tryPostContentsAdd(contentsRequest: ContentsPostData){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(ContentsRetrofitInterface::class.java)
        homeRetrofitInterface.postComment(contentsRequest).enqueue(object : Callback<ContentsPostResponse> {
            override fun onResponse(call: Call<ContentsPostResponse>, response: Response<ContentsPostResponse>) {
                homeInterface.onGetCommentAddSuccess(response.body() as ContentsPostResponse)

            }

            override fun onFailure(call: Call<ContentsPostResponse>, t: Throwable) {
                homeInterface.onGetCommentAddFailure(t.message ?: "통신 오류")
            }
        })
    }
}