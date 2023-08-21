package co.id.cpn.search_ui.screen

import androidx.lifecycle.ViewModel
import co.id.cpn.common.models.ErrorState
import co.id.cpn.search_ui.model.SearchState
import co.id.cpn.search_ui.model.SearchUiEvent
import co.id.cpn.search_ui.model.resultErrorState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel : ViewModel() {

    private val _state = MutableStateFlow(SearchState())
    val state = _state.asStateFlow()

    private fun setState(stateValue: SearchState) {
        _state.value = stateValue
    }

    fun onUiEvent(event: SearchUiEvent) {
        when (event) {
            is SearchUiEvent.SearchTextChanged -> {
                setState(
                    state.value.copy(
                        searchText = event.inputValue,
                        errorState = state.value.errorState.copy(
                            searchErrorState = if (event.inputValue.trim().isNotEmpty())
                                ErrorState()
                            else
                                resultErrorState
                        )
                    )
                )
            }

            // Clear
            is SearchUiEvent.Clear -> {
                setState(state.value.copy(searchText = ""))
            }

            // Submit
            is SearchUiEvent.Submit -> {
                setState(state.value.copy(isResultSuccessful = true))
            }
        }
    }
}