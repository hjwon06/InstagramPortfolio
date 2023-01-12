package com.softsquared.template.kotlin.src.main.contents.model

import com.google.gson.annotations.SerializedName

data class ContentsPostData (
    @SerializedName("postIdx")
    val postIdx : Int?,
    @SerializedName("userIdx")
    val userIdx : Int,
    @SerializedName("parentIdx")
    val parentIdx : Int,
    @SerializedName("depth")
    val depth : Int,
    @SerializedName("contents")
    val contents : String
)