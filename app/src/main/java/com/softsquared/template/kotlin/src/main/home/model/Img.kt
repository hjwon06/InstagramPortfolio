package com.softsquared.template.kotlin.src.main.home.model


import com.google.gson.annotations.SerializedName

data class Img(
    @SerializedName("imgIdx")
    val imgIdx: Int,
    @SerializedName("imgUrl")
    val imgUrl: String
)