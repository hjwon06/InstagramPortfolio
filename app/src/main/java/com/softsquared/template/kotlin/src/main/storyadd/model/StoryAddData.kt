package com.softsquared.template.kotlin.src.main.storyadd.model

import com.google.gson.annotations.SerializedName

data class StoryAddData(
    @SerializedName("userIdx")
    val userIdx : Int?,
    @SerializedName("imageURL")
    val imageURL : String?,
)
