package com.android.demo.bindables

import androidx.databinding.Bindable
import androidx.lifecycle.viewModelScope
import com.component.bindables.BindingViewModel
import com.component.bindables.asBindingProperty
import com.component.bindables.bindingProperty
import com.android.demo.bindables.recycler.Poster
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
public class BindablesViewModel @Inject constructor() : BindingViewModel() {

  private val stateFlow = MutableStateFlow(listOf<Poster>())

  @get:Bindable
  public val data: List<Poster>? by stateFlow.asBindingProperty()

  @get:Bindable
  public var isLoading: Boolean by bindingProperty(false)
    private set

  @get:Bindable
  public var toast: String? by bindingProperty(null)
    private set

  init {
    viewModelScope.launch {
      isLoading = true

      delay(2000)

      stateFlow.emit(MockUtil.getMockPosters())

      isLoading = false

      toast = "finished loading data"
    }
  }
}
