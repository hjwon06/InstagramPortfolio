package com.softsquared.template.kotlin.src.main.signup.model

import com.google.gson.annotations.SerializedName

data class SignUpData(

    @SerializedName("nickName") val nickName: String,
    @SerializedName("password") val password: String
)
