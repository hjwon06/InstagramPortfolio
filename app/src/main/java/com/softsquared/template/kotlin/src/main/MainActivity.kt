package com.softsquared.template.kotlin.src.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityMainBinding
import com.softsquared.template.kotlin.src.main.contents.ContentsFragment
import com.softsquared.template.kotlin.src.main.home.HomeFragment
import com.softsquared.template.kotlin.src.main.myPage.MyPageFragment
import com.softsquared.template.kotlin.src.main.search.SearchFragment

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottomNavigationHide(false)
//        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()

        binding.mainBtmNav.run {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_main_btm_nav_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, HomeFragment())
                            .commitAllowingStateLoss()

                    }

                    R.id.menu_main_btm_nav_search -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, SearchFragment())
                            .commitAllowingStateLoss()
                    }

                    R.id.menu_main_btm_nav_my_page -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, MyPageFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }
            selectedItemId = R.id.menu_main_btm_nav_home
        }
    }

    fun bottomNavigationHide(state: Boolean){
        if(state){
            binding.mainBtmNav.visibility = View.GONE
        }else{
            binding.mainBtmNav.visibility = View.VISIBLE
        }
    }
}