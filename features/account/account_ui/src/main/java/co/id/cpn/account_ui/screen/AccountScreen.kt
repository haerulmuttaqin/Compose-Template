package co.id.cpn.account_ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import co.id.cpn.ui.component.topbar.TopBar
import co.id.cpn.ui.compositions.AppComponent
import co.id.cpn.common.R

@Composable
internal fun AccountRoute() {
    AccountScreen()
}

@Composable
fun AccountScreen(
    viewModel: AccountViewModel = hiltViewModel(),
) {
    AppComponent.Layout(topBar = { TopBar(titleResId = R.string.nav_account) }) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Account Screen",
                fontSize = 26.sp,
            )
        }
    }
}