package com.softsquared.template.kotlin.src.main.contents

import com.softsquared.template.kotlin.src.main.contents.model.ContentsPostResponse
import com.softsquared.template.kotlin.src.main.contents.model.ContentsResponse

interface ContentsInterface {

    fun onGetCommentSuccess(response: ContentsResponse)

    fun onGetCommentFailure(message: String)

    fun onGetCommentAddSuccess(response: ContentsPostResponse)

    fun onGetCommentAddFailure(message: String)



}