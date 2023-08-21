package co.id.cpn.point_ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import co.id.cpn.point_ui.screen.PointRoute
import co.id.cpn.point_ui.screen.PointScreen

const val pointRoute = "point_route"

fun NavController.navigateToPoint(navOptions: NavOptions? = null) {
    this.navigate(pointRoute, navOptions)
}

fun NavGraphBuilder.pointScreen() {
    composable(route = pointRoute) {
        PointRoute()
    }
}
