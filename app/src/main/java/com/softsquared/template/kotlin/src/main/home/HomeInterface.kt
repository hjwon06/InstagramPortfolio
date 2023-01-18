package com.softsquared.template.kotlin.src.main.home

import com.softsquared.template.kotlin.src.main.home.model.HomeResponse
import com.softsquared.template.kotlin.src.main.home.model.HomeStroyResponse

interface HomeInterface {

    fun onGetHomeSuccess(response: HomeResponse)

    fun onGetHomeFailure(message: String)

    fun onGetHomeStorySuccess(response: HomeStroyResponse)

    fun onGetHomeStoryFailure(message: String)



}