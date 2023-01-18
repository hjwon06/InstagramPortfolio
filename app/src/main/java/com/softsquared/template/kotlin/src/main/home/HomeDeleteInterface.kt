package com.softsquared.template.kotlin.src.main.home

import com.softsquared.template.kotlin.src.main.home.adapter.HomePostAdapter
import com.softsquared.template.kotlin.src.main.home.model.HomeDeleteResponse
import com.softsquared.template.kotlin.src.main.home.model.HomeLikeResponse
import com.softsquared.template.kotlin.src.main.home.model.HomeResponse
import com.softsquared.template.kotlin.src.main.home.model.HomeStroyResponse

interface HomeDeleteInterface {

    fun onPatchHomeDeleteSuccess(response: HomeDeleteResponse)

    fun onPatchHomeDeleteFailure(message: String)

}