package com.softsquared.template.kotlin.src.main.login

import com.softsquared.template.kotlin.src.main.login.data.LoginResponse
import com.softsquared.template.kotlin.src.main.signup.model.data.IdCheckResponse
import com.softsquared.template.kotlin.src.main.signup.model.data.SignUpResponse

interface LoginInterface {

    fun onPostSignUpSuccess(response: LoginResponse)

    fun onPostSignUpFailure(message: String)

}