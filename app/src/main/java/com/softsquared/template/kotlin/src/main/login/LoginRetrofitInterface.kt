package com.softsquared.template.kotlin.src.main.login

import com.softsquared.template.kotlin.src.main.login.data.LoginData
import com.softsquared.template.kotlin.src.main.login.data.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRetrofitInterface {

    //로그인
    @POST("app/users/logIn")
    fun postLogin(@Body params: LoginData): Call<LoginResponse>

}