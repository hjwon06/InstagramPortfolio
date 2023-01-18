package com.softsquared.template.kotlin.src.main.myPage.model


import com.google.gson.annotations.SerializedName

data class MyPageStoryData(
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("imageURL")
    val imageURL: Any?,
    @SerializedName("nickName")
    val nickName: String?,
    @SerializedName("order")
    val order: Int?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("storyList")
    val storyList: List<Int?>?,
    @SerializedName("userIdx")
    val userIdx: Int?
)