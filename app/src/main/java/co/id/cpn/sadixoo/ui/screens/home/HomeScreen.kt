package co.id.cpn.sadixoo.ui.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.id.cpn.banner_ui.screen.BannerComponent
import co.id.cpn.common.R
import co.id.cpn.ui.component.search.SearchView
import co.id.cpn.ui.component.topbar.TopBar
import co.id.cpn.ui.compositions.AppComponent
import co.id.cpn.ui.theme.AppTheme
import co.id.cpn.ui.theme.SpaceDim
import coil.compose.AsyncImage
import com.mxalbert.sharedelements.SharedElement

@Composable
internal fun HomeRoute(onSearchProduct: () -> Unit) {
    HomeScreen(onSearchProduct = onSearchProduct)
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onSearchProduct: () -> Unit
) {
    AppComponent.Layout(
        modifier = modifier,
        topBar = { TopBar(titleResId = R.string.app_name_alt) })
    { contentPadding ->
        Column(modifier = Modifier
            .padding(contentPadding)
            .fillMaxWidth()
            .verticalScroll(state = rememberScrollState())
        ) {
            SharedElement(key = "search_bar", screenKey = "search_bar_view") {
                Box(modifier = Modifier.padding(SpaceDim.current.spaceMedium)) {
                    SearchView(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.search_product),
                        onClick = { onSearchProduct.invoke() }
                    )
                }
            }
            BannerComponent()
            AppComponent.MediumSpacer()
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Home Screen",
                fontSize = 26.sp
            )
        }
    }
}

@Preview
@Composable
fun HomeIndexScreenPreview() {
    AppTheme {
        HomeScreen(onSearchProduct = {})
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HomeIndexScreenPreviewDark() {
    AppTheme {
        HomeScreen(onSearchProduct = {})
    }
}