package com.softsquared.template.kotlin.src.main.signup.model

import com.google.gson.annotations.SerializedName

data class SignUp(

    @SerializedName("nickName") val userId: String,
    @SerializedName("password") val pw: String
)
