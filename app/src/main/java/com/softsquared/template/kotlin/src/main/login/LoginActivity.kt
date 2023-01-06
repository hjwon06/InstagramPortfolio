package com.softsquared.template.kotlin.src.main.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityLoginBinding
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.main.signup.SingUpIdActivity
import java.util.regex.Pattern

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding.signupTxtHelp.setOnClickListener {
            val intent = Intent(this, SingUpIdActivity::class.java)
            startActivity(intent)
        }

        binding.loginBtn.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
        }

        //id,pw가 쳐지면 버튼 활성화
        //버튼 색깔 활성
        binding.idTxt.addTextChangedListener(object : TextWatcher {
            // 입력이 끝낫을때
            override fun afterTextChanged(p0: Editable?) {

            }
            // 입력 하기 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
    }
}