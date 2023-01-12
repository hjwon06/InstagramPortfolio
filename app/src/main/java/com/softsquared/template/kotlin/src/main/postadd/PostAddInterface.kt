package com.softsquared.template.kotlin.src.main.postadd

import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddResponse

interface PostAddInterface {

    fun onPostAddSuccess(response: HomeAddResponse)

    fun onPostAddFailure(message: String)

}