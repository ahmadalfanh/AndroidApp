package com.alfan.test.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alfan.test.R
import com.alfan.test.utils.view.viewBinding
import com.alfan.test.databinding.ActivityMainBinding
import com.alfan.test.presentation.adapter.TabPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViewPager()

    }

    private fun initViewPager() {
        with(binding) {
            val adapter = TabPagerAdapter(supportFragmentManager, lifecycle)
            viewPager.adapter = adapter

            TabLayoutMediator(tabs, viewPager) { tabs, position ->
                when (position) {
                    0 -> {
                        tabs.text = getString(R.string.txt_General)
                    }

                    1 -> {
                        tabs.text = getString(R.string.txt_Business)
                    }

                    2 -> {
                        tabs.text = getString(R.string.txt_Entertainment)
                    }

                    3 -> {
                        tabs.text = getString(R.string.txt_Health)
                    }

                    4 -> {
                        tabs.text = getString(R.string.txt_Science)
                    }

                    5 -> {
                        tabs.text = getString(R.string.txt_Sports)
                    }

                    6 -> {
                        tabs.text = getString(R.string.txt_Technology)
                    }
                }
            }.attach()
        }
    }
}