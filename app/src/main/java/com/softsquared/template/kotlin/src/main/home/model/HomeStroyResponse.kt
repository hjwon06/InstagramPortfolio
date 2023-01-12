package com.softsquared.template.kotlin.src.main.home.model


import com.google.gson.annotations.SerializedName

data class HomeStroyResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("isSuccess")
    val isSuccess: Boolean?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("result")
    val result: List<HomeStoryData?>?
)