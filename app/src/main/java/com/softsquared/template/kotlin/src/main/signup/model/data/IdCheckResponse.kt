package com.softsquared.template.kotlin.src.main.signup.model.data

data class IdCheckResponse(
    val code: Int?,
    val isSuccess: Boolean?,
    val message: String?,
    val result: String?
)