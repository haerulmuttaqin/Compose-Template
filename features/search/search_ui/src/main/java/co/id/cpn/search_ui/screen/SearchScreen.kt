package co.id.cpn.search_ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import co.id.cpn.common.R
import co.id.cpn.search_ui.model.SearchUiEvent
import co.id.cpn.ui.component.search.SearchBarUI
import co.id.cpn.ui.component.topbar.TopBar
import co.id.cpn.ui.compositions.AppComponent
import co.id.cpn.ui.theme.AppTheme


@Composable
internal fun SearchRoute(navController: NavController) {
    SearchScreen(navController = navController)
}

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    navController: NavController
) {
    val state by viewModel.state.collectAsState()

    SearchBarUI(
        searchText = state.searchText,
        placeholderText = stringResource(id = R.string.search_product),
        onSearchTextChanged = {
            viewModel.onUiEvent(
                event = SearchUiEvent.SearchTextChanged(it)
            )
        },
        onClearClick = {
            viewModel.onUiEvent(
                event = SearchUiEvent.Clear
            )
        },
        onNavigateBack = {
            navController.navigateUp()
        },
        matchesFound = false
    ) {

    }
}

@Preview
@Composable
fun SearchScreenView() {
    AppTheme {
        SearchRoute(navController = rememberNavController())
    }
}