package com.softsquared.template.kotlin.src.main.storyadd

import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddResponse
import com.softsquared.template.kotlin.src.main.storyadd.model.StoryAddResponse

interface StoryAddInterface {

    fun onPostAddSuccess(response: StoryAddResponse)

    fun onPostAddFailure(message: String)

}