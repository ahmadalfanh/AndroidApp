package com.alfan.test.presentation.content

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alfan.test.R
import com.alfan.test.core.Resource
import com.alfan.test.databinding.FragmentEntertainmentBinding
import com.alfan.test.presentation.ContentViewModel
import com.alfan.test.presentation.adapter.ContentAdapter
import com.alfan.test.utils.view.DataBindingFragment
import org.koin.android.ext.android.inject


class EntertainmentFragment : DataBindingFragment<FragmentEntertainmentBinding>() {
    private val viewModel by inject<ContentViewModel>()
    private lateinit var contentAdapter: ContentAdapter

    override fun layoutId(): Int = R.layout.fragment_entertainment


    override fun onViewCreatedFragment(savedInstanceState: Bundle?) {
        getData()
        initAdapter()
    }

    private fun initAdapter() {
        contentAdapter = ContentAdapter()
        binding.rvHeadlineNews.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHeadlineNews.setHasFixedSize(true)
        binding.rvHeadlineNews.isNestedScrollingEnabled = false
        binding.rvHeadlineNews.adapter = contentAdapter
    }

    private fun getData() {
        viewModel.getTopHeadlinesNews("entertainment").observe(viewLifecycleOwner) {
            if (it != null) {
                when (it) {
                    is Resource.Loading -> {
                        showLoading(false)
                    }
                    is Resource.Success -> {
                        dismissLoading()
                        contentAdapter.addData(it.data?.articles.orEmpty())
                    }

                    is Resource.Error -> {
                        dismissLoading()
                    }

                }
            }
        }
    }

}