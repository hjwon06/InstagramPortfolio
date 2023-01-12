package com.softsquared.template.kotlin.src.main.search

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.login.data.LoginData
import com.softsquared.template.kotlin.src.main.login.data.LoginResponse
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddResponse
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddTwoData
import com.softsquared.template.kotlin.src.main.search.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchService(val searcgInterface: SearchInterface)  {

    //회원가입
    fun tryPostSearchRan(){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(SearchRetrofitInterface::class.java)
        homeRetrofitInterface.getPost().enqueue(object : Callback<SearchResponse> {
            override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                searcgInterface.onPostSearchSuccess(response.body() as SearchResponse)
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                searcgInterface.onPostSearchFailure(t.message ?: "통신 오류")
            }

        })
    }

}