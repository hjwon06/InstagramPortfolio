package com.softsquared.template.kotlin.src.main.signup

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.signup.model.data.IdCheckResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IdCheckService(val idCheckInterface: IdCheckInterface)  {

    //아이디 중복체크
    fun tryGetUsers(id : String){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(SignUpRetrofitInterface::class.java)
        homeRetrofitInterface.getUsers(id).enqueue(object : Callback<IdCheckResponse> {
            override fun onResponse(call: Call<IdCheckResponse>, response: Response<IdCheckResponse>) {
                idCheckInterface.onGetIdCheckSuccess(response.body() as IdCheckResponse)
            }

            override fun onFailure(call: Call<IdCheckResponse>, t: Throwable) {
                idCheckInterface.onGetIdCheckFailure(t.message ?: "통신 오류")
            }
        })
    }
}