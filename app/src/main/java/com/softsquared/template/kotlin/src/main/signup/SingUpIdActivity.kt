package com.softsquared.template.kotlin.src.main.signup

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.content.ContextCompat
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivitySignupIdBinding
import com.softsquared.template.kotlin.src.main.login.LoginActivity
import com.softsquared.template.kotlin.src.main.signup.model.data.IdCheckResponse
import com.softsquared.template.kotlin.src.main.signup.model.data.SignUpResponse
import java.util.regex.Pattern

class SingUpIdActivity : BaseActivity<ActivitySignupIdBinding>(ActivitySignupIdBinding::inflate),IdCheckInterface {
    var btnBool = false
    private lateinit var mPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPreferences = getSharedPreferences("id", Context.MODE_PRIVATE)
        binding.backBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.nextBtn.setOnClickListener{

            IdCheckService(this).tryGetUsers(binding.idTxt.text.toString())

        }


        //버튼 색깔 활성
        binding.idTxt.addTextChangedListener(object : TextWatcher{
            // 입력이 끝낫을때
            override fun afterTextChanged(p0: Editable?) {
                //아이디 에러메시지
                if(Pattern.matches("^[0-9]*$",binding.idTxt.text) && binding.idTxt.text!!.isNotEmpty()) {
                    binding.errorTxt.text = "사용자 이름에 숫자만 포함할 수는 없습니다."
                    binding.idTxt.setBackgroundResource(R.drawable.error_edtxt_border)
                    btnBool = false
                }else if(Pattern.matches("^[a-zA-Z0-9]*\$",binding.idTxt.text)) {
                        binding.errorTxt.text = null
                        binding.idTxt.setBackgroundResource(R.drawable.round)
                        btnBool = true
                }else {
                    binding.errorTxt.text = "사용자 이름에는 문자,숫자 밑줄 및 마침표만 사용할 수 있습니다."
                    binding.idTxt.setBackgroundResource(R.drawable.error_edtxt_border)
                    btnBool = false
                }

            }
            // 입력 하기 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(btnBool) {
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

    override fun onGetIdCheckSuccess(response: IdCheckResponse) {
        val intent = Intent(this, SingUpPwActivity::class.java)
        val editor = mPreferences.edit()
        Log.d("IdCheck", response.result.toString())
        if(response.isSuccess == false) {
            binding.errorTxt.text = response.message
            binding.idTxt.setBackgroundResource(R.drawable.error_edtxt_border)
            btnBool = false
        }else {
            editor.putString("id",response.result.toString())
            editor.apply()
            startActivity(intent)
        }

    }

    override fun onGetIdCheckFailure(message: String) {
        Log.d("error","오류 : $message")
    }


}