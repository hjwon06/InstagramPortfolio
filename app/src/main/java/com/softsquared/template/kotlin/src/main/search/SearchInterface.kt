package com.softsquared.template.kotlin.src.main.search

import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddResponse
import com.softsquared.template.kotlin.src.main.search.model.SearchResponse

interface SearchInterface {

    fun onPostSearchSuccess(response: SearchResponse)

    fun onPostSearchFailure(message: String)

}