package com.alfan.test.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alfan.test.presentation.content.BusinessFragment
import com.alfan.test.presentation.content.EntertainmentFragment
import com.alfan.test.presentation.content.Generalragment
import com.alfan.test.presentation.content.HealthFragment
import com.alfan.test.presentation.content.ScienceFragment
import com.alfan.test.presentation.content.SportsFragment
import com.alfan.test.presentation.content.TechnologyFragment

class TabPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 6
    }


    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                Generalragment()
            }

            1 -> {
                BusinessFragment()
            }

            2 -> {
                EntertainmentFragment()
            }

            3 -> {
                HealthFragment()
            }

            4 -> {
                ScienceFragment()
            }

            5 -> {
                SportsFragment()
            }

            6 -> {
                TechnologyFragment()
            }

            else -> {
                Fragment()
            }
        }
    }
}