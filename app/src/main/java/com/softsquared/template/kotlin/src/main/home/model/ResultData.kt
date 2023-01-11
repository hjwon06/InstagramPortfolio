package com.softsquared.template.kotlin.src.main.home.model


import com.google.gson.annotations.SerializedName

data class ResultData(
    @SerializedName("commentCount")
    val commentCount: Int?,
    @SerializedName("contents")
    val contents: String?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("imgs")
    val imgs: List<Img?>?,
    @SerializedName("likeOrNot")
    val likeOrNot: String?,
    @SerializedName("nickName")
    val nickName: String?,
    @SerializedName("postIdx")
    val postIdx: Int?,
    @SerializedName("postLikeCount")
    val postLikeCount: Int?,
    @SerializedName("profileImgUrl")
    val profileImgUrl: Any? = "test",
    @SerializedName("userIdx")
    val userIdx: Int?
)