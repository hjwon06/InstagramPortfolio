package com.softsquared.template.kotlin.src.main.signup

import com.softsquared.template.kotlin.src.main.signup.model.data.IdCheckResponse
import com.softsquared.template.kotlin.src.main.signup.model.data.SignUpData
import com.softsquared.template.kotlin.src.main.signup.model.data.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SignUpRetrofitInterface {

    //아이디 체크
    @GET("app/users/nickName/{id}")
    fun getUsers(@Path("id")id:String) : Call<IdCheckResponse>

    //회원가입
    @POST("app/users")
    fun postSignUp(@Body params: SignUpData): Call<SignUpResponse>

}