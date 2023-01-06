package com.softsquared.template.kotlin.util

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import com.softsquared.template.kotlin.databinding.DialogLoadingBinding
import com.softsquared.template.kotlin.databinding.DialogLoginErrorBinding

class LoginErrorDialog(context: Context) : Dialog(context) {
    private lateinit var binding: DialogLoginErrorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogLoginErrorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCanceledOnTouchOutside(false)
        setCancelable(false)
        window!!.setBackgroundDrawable(ColorDrawable())
        window!!.setDimAmount(0.2f)
    }

    override fun show() {
        if(!this.isShowing) super.show()
    }
}