package com.softsquared.template.kotlin.src.main.login

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.login.data.LoginData
import com.softsquared.template.kotlin.src.main.login.data.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService(val loginInterface: LoginInterface)  {

    //회원가입
    fun tryPostSignUp(postLoginRequest: LoginData){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(LoginRetrofitInterface::class.java)
        homeRetrofitInterface.postLogin(postLoginRequest).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                loginInterface.onPostSignUpSuccess(response.body() as LoginResponse)
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                loginInterface.onPostSignUpFailure(t.message ?: "통신 오류")
            }

        })
    }

}