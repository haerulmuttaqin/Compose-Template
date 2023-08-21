package co.id.cpn.search_ui.model

import co.id.cpn.common.models.ErrorState

data class SearchState(
    val searchText: String = "",
    val errorState: SearchErrorState = SearchErrorState(),
    val isResultSuccessful: Boolean = false
)

data class SearchErrorState(
    val searchErrorState: ErrorState = ErrorState(),
)