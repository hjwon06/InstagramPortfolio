package com.softsquared.template.kotlin.src.main.home.model

import com.google.gson.annotations.SerializedName

data class HomeLikeData(
    @SerializedName("userIdx") val userIdx: String,
    @SerializedName("postIdx") val postIdx: String
)
