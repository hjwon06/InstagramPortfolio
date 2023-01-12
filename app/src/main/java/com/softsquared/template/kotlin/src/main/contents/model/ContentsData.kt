package com.softsquared.template.kotlin.src.main.contents.model


import com.google.gson.annotations.SerializedName

data class ContentsData(
    @SerializedName("commentIdx")
    val commentIdx: Int?,
    @SerializedName("commentLikeCount")
    val commentLikeCount: Int?,
    @SerializedName("contents")
    val contents: String?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("likeOrNot")
    val likeOrNot: String?,
    @SerializedName("nickName")
    val nickName: String?,
    @SerializedName("postIdx")
    val postIdx: Int?,
    @SerializedName("profileImgUrl")
    val profileImgUrl: Any?,
    @SerializedName("replyYN")
    val replyYN: List<ReplyYN>?,
    @SerializedName("userIdx")
    val userIdx: Int?
)