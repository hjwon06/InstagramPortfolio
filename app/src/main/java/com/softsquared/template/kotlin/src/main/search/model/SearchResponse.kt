package com.softsquared.template.kotlin.src.main.search.model


import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("isSuccess")
    val isSuccess: Boolean?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("result")
    val result: List<SearchData?>?
)