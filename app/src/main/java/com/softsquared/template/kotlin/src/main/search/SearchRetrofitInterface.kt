package com.softsquared.template.kotlin.src.main.search

import com.softsquared.template.kotlin.src.main.login.data.LoginData
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddResponse
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddTwoData
import com.softsquared.template.kotlin.src.main.search.model.SearchResponse
import retrofit2.Call
import retrofit2.http.*

interface SearchRetrofitInterface {

    //게시글 등록하기
    @GET("posts/random")
    fun getPost() : Call<SearchResponse>



}