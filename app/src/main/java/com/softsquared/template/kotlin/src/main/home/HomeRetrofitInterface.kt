package com.softsquared.template.kotlin.src.main.home

import com.softsquared.template.kotlin.src.main.home.model.HomeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeRetrofitInterface {

    //게시글 불러오기
    @GET("posts")
    fun getPost(@Query("userIdx")userIdx:Int) : Call<HomeResponse>



}