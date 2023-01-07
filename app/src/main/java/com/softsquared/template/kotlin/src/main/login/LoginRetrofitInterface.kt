package com.softsquared.template.kotlin.src.main.login

import com.softsquared.template.kotlin.src.main.login.data.LoginData
import com.softsquared.template.kotlin.src.main.login.data.LoginResponse
import com.softsquared.template.kotlin.src.main.signup.model.data.IdCheckResponse
import com.softsquared.template.kotlin.src.main.signup.model.data.SignUpData
import com.softsquared.template.kotlin.src.main.signup.model.data.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface LoginRetrofitInterface {

    //로그인
    @POST("app/users/logIn")
    fun postLogin(@Body params: LoginData): Call<LoginResponse>

}