package co.id.cpn.login_ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import co.id.cpn.login_ui.screen.LoginRoute

const val loginRoute = "login_route"

fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.navigate(loginRoute, navOptions)
}

fun NavGraphBuilder.loginScreen(
    onRegisterClick: () -> Unit,
    onNavigateToHome: () -> Unit,
) {
    composable(route = loginRoute) {
        LoginRoute(onRegisterClick, onNavigateToHome)
    }
}
