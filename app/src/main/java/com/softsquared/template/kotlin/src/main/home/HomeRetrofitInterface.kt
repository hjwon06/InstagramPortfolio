package com.softsquared.template.kotlin.src.main.home

import com.softsquared.template.kotlin.src.main.home.model.HomeLikeResponse
import com.softsquared.template.kotlin.src.main.home.model.HomeResponse
import com.softsquared.template.kotlin.src.main.login.data.LoginData
import com.softsquared.template.kotlin.src.main.login.data.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface HomeRetrofitInterface {

    //게시글 불러오기
    @GET("posts")
    fun getPost(@Query("userIdx")userIdx:Int) : Call<HomeResponse>

    //좋아요 누르기
    @POST("posts/like")
    fun postLike(@Query("userIdx")userIdx:Int,
    @Query("postIdx")postIdx:Int): Call<HomeLikeResponse>



}