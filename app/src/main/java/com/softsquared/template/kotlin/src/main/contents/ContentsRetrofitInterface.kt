package com.softsquared.template.kotlin.src.main.contents

import com.softsquared.template.kotlin.src.main.contents.model.ContentsPostData
import com.softsquared.template.kotlin.src.main.contents.model.ContentsPostResponse
import com.softsquared.template.kotlin.src.main.contents.model.ContentsResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ContentsRetrofitInterface {

    //댓글 불러오기
    @GET("posts/comments")
    fun getComment(@Query("userIdx")userIdx:Int,
                @Query("postIdx")postIdx:Int) : Call<ContentsResponse>


    //댓글 등록하기
    @POST("posts/comment")
    fun postComment(@Body params: ContentsPostData): Call<ContentsPostResponse>

}