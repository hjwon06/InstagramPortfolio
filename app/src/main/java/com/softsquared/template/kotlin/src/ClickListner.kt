package com.softsquared.template.kotlin.src

import android.view.View
import com.softsquared.template.kotlin.databinding.HomePostItemBinding
import com.softsquared.template.kotlin.databinding.HomeStoryItemBinding

interface ClickListner {
    fun onViewClick(view: HomePostItemBinding, position: Int)
    fun onStoryClick(view: HomeStoryItemBinding,position: Int)
    fun onDeleteClick(view: View,position: Int)
}