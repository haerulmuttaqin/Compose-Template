package co.id.cpn.point_ui.screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PointViewModel: ViewModel() {

    private val _state = MutableStateFlow(PointState())
    val state = _state.asStateFlow()
}

class PointState