package com.softsquared.template.kotlin.src.main.home

import com.softsquared.template.kotlin.src.main.home.model.HomeResponse

interface HomeInterface {

    fun onGetHomeSuccess(response: HomeResponse)

    fun onGetHomeFailure(message: String)

}