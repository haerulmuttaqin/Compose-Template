package co.id.cpn.sadixoo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import co.id.cpn.account_ui.navigation.accountScreen
import co.id.cpn.category_ui.navigation.categoryScreen
import co.id.cpn.login_ui.navigation.loginRoute
import co.id.cpn.login_ui.navigation.loginScreen
import co.id.cpn.login_ui.navigation.navigateToLogin
import co.id.cpn.point_ui.navigation.pointScreen
import co.id.cpn.register_ui.navigation.navigateToRegister
import co.id.cpn.register_ui.navigation.registerScreen
import co.id.cpn.sadixoo.ui.AppScreen
import co.id.cpn.sadixoo.ui.appGraph
import co.id.cpn.sadixoo.ui.authGraph
import co.id.cpn.sadixoo.ui.navigateToAppGraph
import co.id.cpn.sadixoo.ui.screens.home.navigation.homeScreen
import co.id.cpn.sadixoo.ui.screens.welcome.navigation.welcomeRoute
import co.id.cpn.sadixoo.ui.screens.welcome.navigation.welcomeScreen

@Composable
fun RootNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = "root",
        startDestination = appGraph
    ) {
        welcomeScreen(gotoHomeIndex = {
            navController.navigateToLogin(navOptions {
                popUpTo(route = welcomeRoute) {
                    inclusive = true
                }
            })
        })
        authNavGraph(navController = navController)
        appGraph(navController = navController)
    }
}