package com.softsquared.template.kotlin.src.main.home.model

import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.config.BaseResponse

data class HomeLikeResponse(
    @SerializedName("result") val result: String

): BaseResponse()

