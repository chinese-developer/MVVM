package com.android.demo.bindables.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.component.bindables.BindingListAdapter
import com.android.demo.bindables.recycler.Poster
import com.component.whatif.whatIfNotNullAs

public object RecyclerViewBinding {
  @JvmStatic
  @BindingAdapter("submitList")
  public fun bindAdapterPosterList(view: RecyclerView, itemList: List<Poster>?) {
    view.adapter.whatIfNotNullAs<BindingListAdapter<Any, *>> { adapter ->
      adapter.submitList(itemList)
    }
  }
}
