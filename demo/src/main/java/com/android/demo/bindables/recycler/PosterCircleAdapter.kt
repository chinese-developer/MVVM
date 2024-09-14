package com.android.demo.bindables.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.demo.R
import com.android.demo.bindables.recycler.PosterCircleAdapter.PosterViewHolder
import com.android.demo.databinding.ItemPosterCircleBinding
import com.component.bindables.BindingListAdapter
import com.component.bindables.binding

public class PosterCircleAdapter : BindingListAdapter<Poster, PosterViewHolder>(PosterDiffUtil()) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
    val binding = parent.binding<ItemPosterCircleBinding>(R.layout.item_poster_circle)
    return PosterViewHolder(binding)
  }

  override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
    holder.binding.poster = getItem(position)
    holder.binding.executePendingBindings()
  }

  public class PosterViewHolder(public val binding: ItemPosterCircleBinding) :
    RecyclerView.ViewHolder(binding.root)
}
