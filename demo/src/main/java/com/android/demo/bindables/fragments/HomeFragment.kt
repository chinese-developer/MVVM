package com.android.demo.bindables.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.android.demo.R
import com.android.demo.bindables.BindablesViewModel
import com.android.demo.bindables.recycler.PosterAdapter
import com.android.demo.databinding.FragmentHomeBinding
import com.component.bindables.BindingFragment

public class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

  private val vm: BindablesViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    super.onCreateView(inflater, container, savedInstanceState)
    return binding {
      viewModel = vm
      adapter = PosterAdapter()
    }.root
  }
}
