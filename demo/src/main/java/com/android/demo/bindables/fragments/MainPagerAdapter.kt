package com.android.demo.bindables.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

public class MainPagerAdapter(fm: FragmentManager) :
  FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

  override fun getItem(position: Int): Fragment {
    return when (position) {
      0 -> HomeFragment()
      1 -> LibraryFragment()
      else -> RadioFragment()
    }
  }

  override fun getCount(): Int = 3
}
