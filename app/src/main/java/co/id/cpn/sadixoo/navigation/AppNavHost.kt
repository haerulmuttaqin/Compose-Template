package co.id.cpn.sadixoo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import co.id.cpn.account_ui.navigation.accountScreen
import co.id.cpn.category_ui.navigation.categoryScreen
import co.id.cpn.point_ui.navigation.pointScreen
import co.id.cpn.sadixoo.ui.appGraph
import co.id.cpn.sadixoo.ui.screens.home.navigation.homeRoute
import co.id.cpn.sadixoo.ui.screens.home.navigation.homeScreen
import co.id.cpn.search_ui.navigation.navigateToSearch
import co.id.cpn.search_ui.navigation.searchScreen

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = appGraph,
        startDestination = homeRoute,
    ) {
        searchScreen(navController = navController)
        homeScreen(
            onSearchProduct = {
                navController.navigateToSearch()
            }
        )
        categoryScreen()
        pointScreen()
        accountScreen()
    }
}