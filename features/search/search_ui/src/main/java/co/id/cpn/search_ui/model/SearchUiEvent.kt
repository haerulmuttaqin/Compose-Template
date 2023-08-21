package co.id.cpn.search_ui.model

sealed class SearchUiEvent {
    data class SearchTextChanged(val inputValue: String) : SearchUiEvent()
    object Clear : SearchUiEvent()
    object Submit : SearchUiEvent()
}