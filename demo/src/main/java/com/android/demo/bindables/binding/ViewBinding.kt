package com.android.demo.bindables.binding

import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.component.whatif.whatIfNotNullOrEmpty

public object ViewBinding {
  @JvmStatic
  @BindingAdapter("loadImage")
  public fun bindLoadImage(view: AppCompatImageView, url: String?) {
    Glide.with(view.context)
      .load(url)
      .into(view)
  }

  @JvmStatic
  @BindingAdapter("pagerAdapter")
  public fun bindPagerAdapter(view: ViewPager2, adapter: FragmentStateAdapter) {
    view.adapter = adapter
    view.offscreenPageLimit = 3
  }

  @JvmStatic
  @BindingAdapter("gone")
  public fun bindGone(view: View, shouldBeGone: Boolean?) {
    if (shouldBeGone == true) {
      view.visibility = View.GONE
    } else {
      view.visibility = View.VISIBLE
    }
  }

  @JvmStatic
  @BindingAdapter("toast")
  public fun bindToast(view: View, text: String?) {
    text.whatIfNotNullOrEmpty {
      Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
    }
  }
}
