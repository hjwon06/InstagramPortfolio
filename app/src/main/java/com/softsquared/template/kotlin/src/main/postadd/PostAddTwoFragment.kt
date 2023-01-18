package com.softsquared.template.kotlin.src.main.postadd

import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentPostAddOneBinding
import com.softsquared.template.kotlin.databinding.FragmentPostAddTwoBinding
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.main.home.HomeFragment
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddResponse
import com.softsquared.template.kotlin.src.main.postadd.model.HomeAddTwoData

class PostAddTwoFragment: BaseFragment<FragmentPostAddTwoBinding>(FragmentPostAddTwoBinding::bind, R.layout.fragment_post_add_two),PostAddInterface {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imgUrl = ApplicationClass.sSharedPreferences.getString("imgUrl","")
        val userIdx = ApplicationClass.sSharedPreferences.getInt("userIdx",0)
        val mainAct = activity as MainActivity
        mainAct.bottomNavigationHide(true)
        Log.d("test", "test : " + userIdx)
        Glide.with(binding.root).load(imgUrl).into(binding.postAddPic2)
        binding.postBackBtn.setOnClickListener {
            parentFragmentManager.beginTransaction().remove(this).commit()
        }

        binding.postAddBtn.setOnClickListener {
            PostAddService(this).tryPostAdd(userIdx, HomeAddTwoData(binding.postAddTxt.text.toString(),
                listOf(imgUrl) as List<String>))
//            parentFragmentManager.beginTransaction().remove().commit()
            parentFragmentManager.beginTransaction().replace(R.id.main_frm,HomeFragment()).commit()
            mainAct.bottomNavigationHide(false)
        }
    }

    override fun onPostAddSuccess(response: HomeAddResponse) {
        if(response.isSuccess) {
            Log.d("test","test123")
        }

    }

    override fun onPostAddFailure(message: String) {
        Log.d("test2",message)
    }
}