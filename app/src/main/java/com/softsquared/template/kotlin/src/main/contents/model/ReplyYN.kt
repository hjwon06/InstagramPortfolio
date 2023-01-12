package com.softsquared.template.kotlin.src.main.contents.model


import com.google.gson.annotations.SerializedName

data class ReplyYN(
    @SerializedName("replyCount")
    val replyCount: Int?,
    @SerializedName("replyYn")
    val replyYn: Int?
)