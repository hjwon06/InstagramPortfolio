package com.softsquared.template.kotlin.src.main.home

import com.softsquared.template.kotlin.src.main.home.adapter.HomePostAdapter
import com.softsquared.template.kotlin.src.main.home.model.HomeLikeResponse
import com.softsquared.template.kotlin.src.main.home.model.HomeResponse

interface HomeLikeInterface {

    fun onPostHomeLikeSuccess(response: HomeLikeResponse)

    fun onPostHomeLikeFailure(message: String)

}