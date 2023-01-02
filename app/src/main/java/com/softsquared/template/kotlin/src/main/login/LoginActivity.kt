package com.softsquared.template.kotlin.src.main.login

import android.content.Intent
import android.os.Bundle
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityLoginBinding
import com.softsquared.template.kotlin.src.main.signup.SingUpIdActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding.signupTxtHelp.setOnClickListener {
            val intent = Intent(this, SingUpIdActivity::class.java)
            startActivity(intent)
        }
    }
}