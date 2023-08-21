package co.id.cpn.point_ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import co.id.cpn.common.R
import co.id.cpn.ui.component.topbar.TopBar
import co.id.cpn.ui.compositions.AppComponent
import co.id.cpn.ui.theme.ColorSystem

@Composable
internal fun PointRoute() {
    PointScreen()
}

@Composable
fun PointScreen(
    viewModel: PointViewModel = hiltViewModel(),
) {
    AppComponent.Layout(topBar = { TopBar(titleResId = R.string.nav_point) }) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Point Screen",
                fontSize = 26.sp,
            )
        }
    }
}