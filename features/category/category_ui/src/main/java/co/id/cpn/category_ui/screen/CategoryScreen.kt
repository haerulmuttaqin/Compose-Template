package co.id.cpn.category_ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import co.id.cpn.common.R
import co.id.cpn.ui.component.topbar.TopBar
import co.id.cpn.ui.compositions.AppComponent


@Composable
internal fun CategoryRoute() {
    CategoryScreen()
}

@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel = hiltViewModel(),
) {
    AppComponent.Layout(topBar = { TopBar(titleResId = R.string.nav_category) }) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Category Screen",
                fontSize = 26.sp,
            )
        }
    }
}