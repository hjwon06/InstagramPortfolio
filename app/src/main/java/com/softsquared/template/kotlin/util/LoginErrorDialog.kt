package com.softsquared.template.kotlin.util

import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.TextView
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.databinding.DialogLoginErrorBinding

class LoginErrorDialog(context: Context) : Dialog(context) {
    private lateinit var binding: DialogLoginErrorBinding
    private var mPreferences: SharedPreferences = context.getSharedPreferences("error",Context.MODE_PRIVATE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val errorState = mPreferences.getBoolean("errorState",false)
        Log.d("test",errorState.toString())
        binding = DialogLoginErrorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCancelable(false)

        binding.tryAgain.setOnClickListener {
            dismiss()
        }

       if(errorState) {
           binding.errorResultTxt.text = "잘못된 사용자 이름"
           binding.errorDesTxt.text = "입력하신 사용자 이름을 사용하는 계정을 찾을 수 없습니다. 사용자 이름을 확인하고 다시 시도하세요."
           binding.tryAgain.text = "다시 시도"
       }else {
           binding.errorResultTxt.text = "비밀번호 오류"
           binding.errorDesTxt.text = "이력된 비밀번호가 올바르지 않습니다. 다시 시도하세요."
           binding.tryAgain.text = "확인"
       }

        //배경 투명
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    }


    fun textAdd(result: String,desTxt: String,tryTxt: String) {
        binding.errorResultTxt.text = result
        binding.errorDesTxt.text = desTxt
        binding.tryAgain.text = tryTxt
    }


}