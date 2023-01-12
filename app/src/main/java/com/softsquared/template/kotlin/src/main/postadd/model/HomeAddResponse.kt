package com.softsquared.template.kotlin.src.main.postadd.model

import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.config.BaseResponse

data class HomeAddResponse (
    @SerializedName("result") val result: HomeAddTwoData

    ): BaseResponse()