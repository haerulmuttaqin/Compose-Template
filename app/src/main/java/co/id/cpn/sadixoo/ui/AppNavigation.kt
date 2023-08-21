package co.id.cpn.sadixoo.ui

import androidx.navigation.*
import androidx.navigation.compose.composable

const val authGraph = "auth_graph"
const val appRoute = "app_route"
const val appGraph = "app_graph"

fun NavController.navigateToAppGraph(navOptions: NavOptions? = null) {
    this.navigate(appGraph, navOptions)
}

fun NavGraphBuilder.appGraph(navController: NavHostController) {
    navigation(
        route = appGraph,
        startDestination = appRoute,
    ) {
        composable(route = appRoute) {
            AppRoute()
        }
    }
}
