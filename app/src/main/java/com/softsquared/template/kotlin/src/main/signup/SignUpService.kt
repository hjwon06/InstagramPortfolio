package com.softsquared.template.kotlin.src.main.signup

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.signup.model.SignUpData
import com.softsquared.template.kotlin.src.main.signup.model.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpService(val signUpInterface: SignUpInterface)  {

    //회원가입
    fun tryPostSignUp(postSignUpRequest: SignUpData){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(SignUpRetrofitInterface::class.java)
        homeRetrofitInterface.postSignUp(postSignUpRequest).enqueue(object : Callback<SignUpResponse> {
            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                signUpInterface.onPostSignUpSuccess(response.body() as SignUpResponse)
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                signUpInterface.onPostSignUpFailure(t.message ?: "통신 오류")
            }
        })
    }

}