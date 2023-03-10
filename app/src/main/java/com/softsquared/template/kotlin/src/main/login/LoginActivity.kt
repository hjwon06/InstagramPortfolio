package com.softsquared.template.kotlin.src.main.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.content.ContextCompat
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.softsquared.template.kotlin.config.ApplicationClass.Companion.sSharedPreferences
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityLoginBinding
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.main.login.data.LoginData
import com.softsquared.template.kotlin.src.main.login.data.LoginResponse
import com.softsquared.template.kotlin.src.main.signup.SingUpIdActivity
import com.softsquared.template.kotlin.util.LoginErrorDialog

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate),LoginInterface {
    var idBool = false
    var pwBool = false
    private lateinit var mPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPreferences = getSharedPreferences("error", Context.MODE_PRIVATE)

        binding.signupTxtHelp.setOnClickListener {
            val intent = Intent(this, SingUpIdActivity::class.java)
            startActivity(intent)
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
                if(binding.idTxt.length() >= 6) {
                    binding.loginBtn.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.colorPrimary))
                    binding.loginBtn.isEnabled = true
                    binding.loginBtn.setBackgroundResource(R.drawable.btn_activation_round)
                }else {
                    binding.loginBtn.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.colorAcivatinBtn))
                    binding.loginBtn.isEnabled = false
                    binding.loginBtn.setBackgroundResource(R.drawable.btn_round)
                }
            }
        })

        binding.pwTxt.addTextChangedListener(object : TextWatcher {
            // 입력이 끝낫을때
            override fun afterTextChanged(p0: Editable?) {

            }
            // 입력 하기 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(binding.pwTxt.length() >= 6) {
                    binding.loginBtn.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.colorPrimary))
                    binding.loginBtn.isEnabled = true
                    binding.loginBtn.setBackgroundResource(R.drawable.btn_activation_round)
                }else {
                    binding.loginBtn.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.colorAcivatinBtn))
                    binding.loginBtn.isEnabled = false
                    binding.loginBtn.setBackgroundResource(R.drawable.btn_round)
                }
            }
        })

        binding.loginBtn.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
            LoginService(this).tryPostSignUp(LoginData(binding.idTxt.text.toString(),binding.pwTxt.text.toString()))
        }

    }

    override fun onPostSignUpSuccess(response: LoginResponse) {
        val editor = mPreferences.edit()
        val jwtEditor = sSharedPreferences.edit()
        if(!response.isSuccess) {
            val myLoginErrorDialog = LoginErrorDialog(this)
//            if(response.code == 4000) {
//                editor.putBoolean("errorState",false)
//            }else {
//                editor.putBoolean("errorState",true)
//            }
            editor.putBoolean("errorState",true)
            editor.apply()
            myLoginErrorDialog.show()
        }else {
            val intent = Intent(this, MainActivity::class.java)
            Log.d("test",response.result.jwt.toString())
            jwtEditor.putString(X_ACCESS_TOKEN,response.result.jwt)
            jwtEditor.putInt("userIdx", response.result.userIdx!!)
            jwtEditor.apply()
            startActivity(intent)
        }
    }

    override fun onPostSignUpFailure(message: String) {
        Log.d("error","오류 : $message")
    }
}