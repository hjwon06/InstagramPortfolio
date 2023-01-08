package com.softsquared.template.kotlin.src.main.signup

import com.softsquared.template.kotlin.src.main.signup.model.IdCheckResponse

interface IdCheckInterface {

    fun onGetIdCheckSuccess(response: IdCheckResponse)

    fun onGetIdCheckFailure(message: String)


}