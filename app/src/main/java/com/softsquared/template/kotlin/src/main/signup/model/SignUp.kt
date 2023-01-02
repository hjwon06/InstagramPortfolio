package com.softsquared.template.kotlin.src.main.signup.model

import com.google.gson.annotations.SerializedName

data class SignUp(

    @SerializedName("userId") val userId: String,
    @SerializedName("pw") val pw: String
)
