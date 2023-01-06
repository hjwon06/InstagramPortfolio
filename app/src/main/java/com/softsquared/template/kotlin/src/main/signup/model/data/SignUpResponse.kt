package com.softsquared.template.kotlin.src.main.signup.model.data

import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.config.BaseResponse

data class SignUpResponse (
    @SerializedName("result") val result: SignUpData

    ): BaseResponse()