package com.softsquared.template.kotlin.src.main.signup

import com.softsquared.template.kotlin.src.main.signup.model.SignUpResponse

interface SignUpInterface {

    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String)

}