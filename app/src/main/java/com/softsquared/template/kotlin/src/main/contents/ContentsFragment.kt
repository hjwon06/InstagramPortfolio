package com.softsquared.template.kotlin.src.main.contents

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentContentsBinding
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.main.contents.adapter.ContentsAdapter
import com.softsquared.template.kotlin.src.main.contents.model.ContentsData
import com.softsquared.template.kotlin.src.main.contents.model.ContentsPostData
import com.softsquared.template.kotlin.src.main.contents.model.ContentsPostResponse
import com.softsquared.template.kotlin.src.main.contents.model.ContentsResponse

class ContentsFragment: BaseFragment<FragmentContentsBinding>(FragmentContentsBinding::bind, R.layout.fragment_contents),ContentsInterface {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainAct = activity as MainActivity
        mainAct.bottomNavigationHide(true)
        val postIdx = ApplicationClass.sSharedPreferences.getInt("postIdx",0)
        val userIdx = ApplicationClass.sSharedPreferences.getInt("userIdx",0)
        ContentsService(this).tryPostContents(userIdx,postIdx)


        binding.contentsBackBtn.setOnClickListener {
            parentFragmentManager.beginTransaction().remove(this).commit()
            mainAct.bottomNavigationHide(false)
        }

        binding.contentsAddBtn.setOnClickListener {
            ContentsService(this).tryPostContentsAdd(ContentsPostData(postIdx,userIdx,0,1,binding.contentsAddTxt.text.toString()))
            parentFragmentManager.beginTransaction().remove(this).add(R.id.main_frm, ContentsFragment()).commit()

        }
    }

    fun refreshFragment(fragment: Fragment, fragmentManager: FragmentManager) {
        var ft: FragmentTransaction = fragmentManager.beginTransaction()
        ft.detach(fragment).attach(fragment).commit()
    }


    override fun onGetCommentSuccess(response: ContentsResponse) {
        val contentsPostAdapter = ContentsAdapter(response.result as List<ContentsData>)
        Log.d("----", "결과 : " + response.result.size)
        binding.contentsList.apply {
            binding.contentsList.adapter = contentsPostAdapter
            setHasFixedSize(true)
        }
    }

    override fun onGetCommentFailure(message: String) {
        Log.d("test2",message)
    }

    override fun onGetCommentAddSuccess(response: ContentsPostResponse) {
        Log.d("test",response.result.toString())

    }

    override fun onGetCommentAddFailure(message: String) {
        Log.d("test2",message)
    }
}