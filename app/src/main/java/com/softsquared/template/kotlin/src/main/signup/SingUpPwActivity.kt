package com.softsquared.template.kotlin.src.main.signup

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.content.ContextCompat
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivitySignupIdBinding
import com.softsquared.template.kotlin.databinding.ActivitySignupPwBinding

class SingUpPwActivity : BaseActivity<ActivitySignupPwBinding>(ActivitySignupPwBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.backBtn.setOnClickListener {
            val intent = Intent(this, SingUpIdActivity::class.java)
            startActivity(intent)
        }
        //버튼 색깔 활성
        binding.pwTxt.addTextChangedListener(object : TextWatcher{
            // 입력이 끝낫을때
            override fun afterTextChanged(p0: Editable?) {

            }
            // 입력 하기 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(binding.pwTxt.length() >= 5) {
                    binding.nextBtn.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.colorPrimary))
                    binding.nextBtn.isEnabled = true
                    binding.nextBtn.setBackgroundResource(R.drawable.btn_activation_round)
                }else {
                    binding.nextBtn.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.colorAcivatinBtn))
                    binding.nextBtn.isEnabled = false
                    binding.nextBtn.setBackgroundResource(R.drawable.btn_round)
                }
            }
        })
    }
}