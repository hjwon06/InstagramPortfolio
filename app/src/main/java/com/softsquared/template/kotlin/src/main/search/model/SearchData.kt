package com.softsquared.template.kotlin.src.main.search.model


import com.google.gson.annotations.SerializedName

data class SearchData(
    @SerializedName("imgIdx")
    val imgIdx: Int?,
    @SerializedName("imgUrl")
    val imgUrl: String?,
    @SerializedName("postIdx")
    val postIdx: Int?
)