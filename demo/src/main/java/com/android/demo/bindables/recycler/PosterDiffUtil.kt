package com.android.demo.bindables.recycler

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

public class PosterDiffUtil<T> : DiffUtil.ItemCallback<T>() {

  override fun areItemsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
    return oldItem.hashCode() == newItem.hashCode()
  }

  @SuppressLint("DiffUtilEquals")
  override fun areContentsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
    return oldItem.hashCode() == newItem.hashCode()
  }
}
