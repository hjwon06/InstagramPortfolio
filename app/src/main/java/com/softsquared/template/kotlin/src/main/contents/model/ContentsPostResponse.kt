package com.softsquared.template.kotlin.src.main.contents.model

import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.config.BaseResponse

data class ContentsPostResponse(
    @SerializedName("result")
    val result: List<ContentsPostResultData?>?
) : BaseResponse()
