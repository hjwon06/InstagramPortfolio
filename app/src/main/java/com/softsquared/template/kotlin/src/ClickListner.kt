package com.softsquared.template.kotlin.src

import com.softsquared.template.kotlin.databinding.HomePostItemBinding

interface ClickListner {
    fun onViewClick(view: HomePostItemBinding, position: Int)
}