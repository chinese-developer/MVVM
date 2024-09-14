package com.android.demo.bindables.recycler

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
public data class Poster(
  val name: String,
  val release: String,
  val playtime: String,
  val description: String,
  val poster: String
) : Parcelable
