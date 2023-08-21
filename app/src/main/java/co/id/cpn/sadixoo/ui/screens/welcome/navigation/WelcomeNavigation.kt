package co.id.cpn.sadixoo.ui.screens.welcome.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import co.id.cpn.sadixoo.ui.screens.home.HomeRoute
import co.id.cpn.sadixoo.ui.screens.welcome.WelcomeRoute

const val welcomeRoute = "welcome_route"

fun NavController.navigateToWelcome(navOptions: NavOptions? = null) {
    this.navigate(welcomeRoute, navOptions)
}

fun NavGraphBuilder.welcomeScreen(gotoHomeIndex: () -> Unit) {
    composable(route = welcomeRoute) {
        WelcomeRoute(gotoHomeIndex = gotoHomeIndex)
    }
}
