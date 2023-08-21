package co.id.cpn.sadixoo.ui.screens.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import co.id.cpn.sadixoo.ui.screens.home.HomeRoute

const val homeRoute = "home_route"

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(homeRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(onSearchProduct: () -> Unit) {
    composable(route = homeRoute) {
        HomeRoute(onSearchProduct = onSearchProduct)
    }
}
