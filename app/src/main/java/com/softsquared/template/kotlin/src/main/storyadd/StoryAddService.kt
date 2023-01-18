package com.softsquared.template.kotlin.src.main.storyadd

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.login.data.LoginData
import com.softsquared.template.kotlin.src.main.login.data.LoginResponse
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddResponse
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddTwoData
import com.softsquared.template.kotlin.src.main.storyadd.model.StoryAddData
import com.softsquared.template.kotlin.src.main.storyadd.model.StoryAddResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StoryAddService(val loginInterface: StoryAddInterface)  {

    //회원가입
    fun tryPostAdd(storyAddRequest: StoryAddData){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(StoryPostRetrofitInterface::class.java)
        homeRetrofitInterface.postStory(storyAddRequest).enqueue(object : Callback<StoryAddResponse> {
            override fun onResponse(call: Call<StoryAddResponse>, response: Response<StoryAddResponse>) {
                loginInterface.onPostAddSuccess(response.body() as StoryAddResponse)
            }

            override fun onFailure(call: Call<StoryAddResponse>, t: Throwable) {
                loginInterface.onPostAddFailure(t.message ?: "통신 오류")
            }

        })
    }

}