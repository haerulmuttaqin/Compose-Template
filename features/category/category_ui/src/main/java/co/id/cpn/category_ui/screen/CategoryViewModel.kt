package co.id.cpn.category_ui.screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CategoryViewModel: ViewModel() {

    private val _state = MutableStateFlow(CategoryState())
    val state = _state.asStateFlow()
}

class CategoryState