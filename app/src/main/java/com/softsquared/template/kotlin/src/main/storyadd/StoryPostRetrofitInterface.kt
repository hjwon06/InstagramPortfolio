package com.softsquared.template.kotlin.src.main.storyadd

import com.softsquared.template.kotlin.src.main.login.data.LoginData
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddResponse
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddTwoData
import com.softsquared.template.kotlin.src.main.storyadd.model.StoryAddData
import com.softsquared.template.kotlin.src.main.storyadd.model.StoryAddResponse
import retrofit2.Call
import retrofit2.http.*

interface StoryPostRetrofitInterface {

    //게시글 등록하기
    @POST("app/story")
    fun postStory(@Body params: StoryAddData
    ) : Call<StoryAddResponse>



}