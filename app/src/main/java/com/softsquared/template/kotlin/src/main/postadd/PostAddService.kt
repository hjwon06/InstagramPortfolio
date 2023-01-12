package com.softsquared.template.kotlin.src.main.postadd

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.login.data.LoginData
import com.softsquared.template.kotlin.src.main.login.data.LoginResponse
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddResponse
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddTwoData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostAddService(val loginInterface: PostAddInterface)  {

    //회원가입
    fun tryPostAdd(userIdx : Int,homeAddRequest: HomeAddTwoData){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(PostAddRetrofitInterface::class.java)
        homeRetrofitInterface.getPost(userIdx,homeAddRequest).enqueue(object : Callback<HomeAddResponse> {
            override fun onResponse(call: Call<HomeAddResponse>, response: Response<HomeAddResponse>) {
                loginInterface.onPostAddSuccess(response.body() as HomeAddResponse)
            }

            override fun onFailure(call: Call<HomeAddResponse>, t: Throwable) {
                loginInterface.onPostAddFailure(t.message ?: "통신 오류")
            }

        })
    }

}