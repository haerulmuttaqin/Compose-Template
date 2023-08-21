package co.id.cpn.sadixoo.navigation

import androidx.navigation.*
import co.id.cpn.login_ui.navigation.loginRoute
import co.id.cpn.login_ui.navigation.loginScreen
import co.id.cpn.register_ui.navigation.navigateToRegister
import co.id.cpn.register_ui.navigation.registerScreen
import co.id.cpn.sadixoo.ui.appGraph
import co.id.cpn.sadixoo.ui.authGraph
import co.id.cpn.sadixoo.ui.navigateToAppGraph

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = authGraph,
        startDestination = loginRoute
    ) {
        loginScreen(
            onRegisterClick = { navController.navigateToRegister() },
            onNavigateToHome = {
                navController.navigateToAppGraph(navOptions = navOptions {
                    popUpTo(route = loginRoute) {
                        inclusive = true
                    }
                })
            }
        )
        registerScreen(
            onLoginClick = navController::popBackStack
        )
    }
}