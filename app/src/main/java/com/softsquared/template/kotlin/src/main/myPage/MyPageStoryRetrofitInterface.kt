package com.softsquared.template.kotlin.src.main.myPage

import com.softsquared.template.kotlin.src.main.contents.model.ContentsPostData
import com.softsquared.template.kotlin.src.main.contents.model.ContentsPostResponse
import com.softsquared.template.kotlin.src.main.contents.model.ContentsResponse
import com.softsquared.template.kotlin.src.main.myPage.model.MyPageStoryResponse
import retrofit2.Call
import retrofit2.http.*

interface MyPageStoryRetrofitInterface {

    //나의 스토리 불러오기
    @GET("app/story/list/my/{userIdx}")
    fun getStory(@Path("userIdx")userIdx:Int) : Call<MyPageStoryResponse>


    //나의 스토리 1개 이미지 불러오기

}