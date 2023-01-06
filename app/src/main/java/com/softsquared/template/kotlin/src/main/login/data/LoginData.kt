package com.softsquared.template.kotlin.src.main.login.data

import com.google.gson.annotations.SerializedName

data class LoginData(

    @SerializedName("nickName") val nickName: String,
    @SerializedName("password") val password: String
)
