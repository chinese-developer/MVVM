package com.android.demo.bindables.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.demo.R
import com.android.demo.bindables.recycler.PosterLineAdapter.PosterViewHolder
import com.android.demo.databinding.ItemPosterLineBinding
import com.component.bindables.BindingListAdapter
import com.component.bindables.binding

public class PosterLineAdapter : BindingListAdapter<Poster, PosterViewHolder>(PosterDiffUtil()) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
    val binding = parent.binding<ItemPosterLineBinding>(R.layout.item_poster_line)
    return PosterViewHolder(binding)
  }

  override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
    holder.binding.poster = getItem(position)
    holder.binding.executePendingBindings()
  }

  public class PosterViewHolder(public val binding: ItemPosterLineBinding) :
    RecyclerView.ViewHolder(binding.root)
}
