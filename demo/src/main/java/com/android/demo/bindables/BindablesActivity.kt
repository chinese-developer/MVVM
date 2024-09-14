package com.android.demo.bindables

import android.os.Bundle
import androidx.activity.viewModels
import androidx.viewpager.widget.ViewPager
import com.android.demo.R
import com.android.demo.databinding.ActivityMainBinding
import com.component.bindables.BindingActivity
import com.android.demo.bindables.fragments.MainPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
public class BindablesActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

  private val viewModel: BindablesViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding.vm = viewModel

    with(binding.mainViewpager) {
      adapter = MainPagerAdapter(supportFragmentManager)
      offscreenPageLimit = 3
      addOnPageChangeListener(
        object : ViewPager.OnPageChangeListener {
          override fun onPageScrollStateChanged(state: Int) = Unit
          override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
          ) = Unit

          override fun onPageSelected(position: Int) {
            binding.mainBottomNavigation.menu.getItem(position).isChecked = true
          }
        }
      )
    }

    binding.mainBottomNavigation.setOnNavigationItemSelectedListener {
      when (it.itemId) {
        R.id.action_one -> binding.mainViewpager.currentItem = 0
        R.id.action_two -> binding.mainViewpager.currentItem = 1
        R.id.action_three -> binding.mainViewpager.currentItem = 2
      }
      true
    }
  }
}
