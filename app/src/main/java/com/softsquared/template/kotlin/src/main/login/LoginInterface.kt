package com.softsquared.template.kotlin.src.main.login

import com.softsquared.template.kotlin.src.main.login.data.LoginResponse

interface LoginInterface {

    fun onPostSignUpSuccess(response: LoginResponse)

    fun onPostSignUpFailure(message: String)

}