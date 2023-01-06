package com.softsquared.template.kotlin.src.main.signup

import com.softsquared.template.kotlin.src.main.signup.model.data.IdCheckResponse
import com.softsquared.template.kotlin.src.main.signup.model.data.SignUpResponse

interface IdCheckInterface {

    fun onGetIdCheckSuccess(response: IdCheckResponse)

    fun onGetIdCheckFailure(message: String)


}