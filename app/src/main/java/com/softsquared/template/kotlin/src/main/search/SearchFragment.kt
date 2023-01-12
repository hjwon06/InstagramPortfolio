package com.softsquared.template.kotlin.src.main.search

import android.os.Bundle
import android.util.Log
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentSearchBinding
import com.softsquared.template.kotlin.src.main.home.adapter.HomePostAdapter
import com.softsquared.template.kotlin.src.main.home.model.ResultData
import com.softsquared.template.kotlin.src.main.myPage.adapter.MyPageFindAdapter
import com.softsquared.template.kotlin.src.main.myPage.model.MyPageFindData
import com.softsquared.template.kotlin.src.main.search.adapter.SearchViewAdapter
import com.softsquared.template.kotlin.src.main.search.model.SearchData
import com.softsquared.template.kotlin.src.main.search.model.SearchResponse
import com.softsquared.template.kotlin.src.main.search.model.SearchViewData


class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::bind, R.layout.fragment_search),SearchInterface {
    private var searchList = arrayListOf<SearchData>()
    private val searchAdapter = SearchViewAdapter(searchList)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchTextBar.setOnClickListener {
            binding.backBtn.visibility = View.VISIBLE
            binding.searchViewList.visibility = View.GONE
        }

        binding.backBtn.setOnClickListener {
            binding.backBtn.visibility = View.GONE
            binding.searchViewList.visibility = View.VISIBLE
        }
        SearchService(this).tryPostSearchRan()
//        recyclerviewControl()
    }

    override fun onPostSearchSuccess(response: SearchResponse) {
        val searchAdapter = SearchViewAdapter(response.result as List<SearchData>)
        binding.searchViewList.apply {
            binding.searchViewList.adapter = searchAdapter
            setHasFixedSize(true)
        }
    }

    override fun onPostSearchFailure(message: String) {
        Log.d("test",message)
    }

//    private fun recyclerviewControl() {
//        binding.searchViewList.apply {
//            binding.searchViewList.adapter = searchAdapter
//            for (i in 0..20) {
//                searchList.add(SearchViewData(R.drawable.ic_search_img, R.drawable.ic_pictures_img))
//            }
//            setHasFixedSize(true)
//        }
//    }



}