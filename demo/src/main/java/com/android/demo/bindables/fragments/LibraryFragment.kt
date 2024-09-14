package com.android.demo.bindables.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.android.demo.R
import com.android.demo.bindables.BindablesViewModel
import com.android.demo.databinding.FragmentLibraryBinding
import com.component.bindables.BindingFragment
import com.android.demo.bindables.recycler.PosterLineAdapter

public class LibraryFragment : BindingFragment<FragmentLibraryBinding>(R.layout.fragment_library) {

  private val vm: BindablesViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    super.onCreateView(inflater, container, savedInstanceState)
    return binding {
      viewModel = vm
      adapter = PosterLineAdapter()
    }.root
  }
}
