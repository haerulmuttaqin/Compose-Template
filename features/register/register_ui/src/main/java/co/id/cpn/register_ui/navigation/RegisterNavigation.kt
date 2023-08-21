package co.id.cpn.register_ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import co.id.cpn.register_ui.screen.RegisterRoute

const val Route = "register_route"

fun NavController.navigateToRegister(navOptions: NavOptions? = null) {
    this.navigate(Route, navOptions)
}

fun NavGraphBuilder.registerScreen(
    onLoginClick: () -> Unit,
) {
    composable(route = Route) {
        RegisterRoute(onLoginClick)
    }
}
