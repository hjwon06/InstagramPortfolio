package com.softsquared.template.kotlin.src.main.home

import com.softsquared.template.kotlin.src.main.home.model.HomeDeleteResponse
import com.softsquared.template.kotlin.src.main.home.model.HomeLikeResponse
import com.softsquared.template.kotlin.src.main.home.model.HomeResponse
import com.softsquared.template.kotlin.src.main.home.model.HomeStroyResponse
import com.softsquared.template.kotlin.src.main.login.data.LoginData
import com.softsquared.template.kotlin.src.main.login.data.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface HomeRetrofitInterface {

    //게시글 불러오기
    @GET("posts/feed")
    fun getPost(@Query("userIdx")userIdx:Int) : Call<HomeResponse>

    //좋아요 누르기
    @POST("posts/like")
    fun postLike(@Query("userIdx")userIdx:Int,
    @Query("postIdx")postIdx:Int): Call<HomeLikeResponse>


    //스토리 불러오기
    @GET("app/story/list/{userIdx}")
    fun getStory(@Path("userIdx")userIdx:Int) : Call<HomeStroyResponse>

    //게시글 삭제
    @PATCH("posts/delete")
    fun patchDelete(@Query("userIdx")userIdx:Int,
                  @Query("postIdx")postIdx:Int) : Call<HomeDeleteResponse>


}