package com.softsquared.template.kotlin.src.main.myPage

import com.softsquared.template.kotlin.src.main.myPage.model.MyPageStoryResponse

interface MyPageStoryInterface {

    fun onGetMyPageStorySuccess(response: MyPageStoryResponse)

    fun onGetMyPageStoryFailure(message: String)




}