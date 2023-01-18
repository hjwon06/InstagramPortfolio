package com.softsquared.template.kotlin.util

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.databinding.DialogPostDeleteBinding
import com.softsquared.template.kotlin.src.ClickListner
import com.softsquared.template.kotlin.src.main.home.HomeDeleteInterface
import com.softsquared.template.kotlin.src.main.home.adapter.HomePostAdapter
import com.softsquared.template.kotlin.src.main.home.model.HomeDeleteResponse

class PostDeleteDialog(context: Context) : Dialog(context) ,HomeDeleteInterface{
    private lateinit var binding: DialogPostDeleteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val postIdx = ApplicationClass.sSharedPreferences.getInt("postIdx",0)
        val userIdx = ApplicationClass.sSharedPreferences.getInt("userIdx",0)
        binding = DialogPostDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCancelable(false)

        binding.deleteBtn.setOnClickListener {
//            HomeDeleteService(this).tryPatchDelete(userIdx,postIdx)
        }

        //배경 투명
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    }

    override fun onPatchHomeDeleteSuccess(response: HomeDeleteResponse) {
        dismiss()
    }

    override fun onPatchHomeDeleteFailure(message: String) {
        Log.d("test2",message)
    }

}