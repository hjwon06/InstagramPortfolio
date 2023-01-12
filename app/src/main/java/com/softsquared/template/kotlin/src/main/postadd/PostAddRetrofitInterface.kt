package com.softsquared.template.kotlin.src.main.postadd

import com.softsquared.template.kotlin.src.main.login.data.LoginData
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddResponse
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddTwoData
import retrofit2.Call
import retrofit2.http.*

interface PostAddRetrofitInterface {

    //게시글 등록하기
    @POST("posts/{userIdx}")
    fun getPost(@Path("userIdx")userIdx:Int,
                @Body params: HomeAddTwoData
    ) : Call<HomeAddResponse>



}