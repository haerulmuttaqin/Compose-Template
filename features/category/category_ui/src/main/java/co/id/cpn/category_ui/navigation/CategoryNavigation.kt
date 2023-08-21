package co.id.cpn.category_ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import co.id.cpn.category_ui.screen.CategoryRoute

const val categoryRoute = "category_route"

fun NavController.navigateToCategory(navOptions: NavOptions? = null) {
    this.navigate(categoryRoute, navOptions)
}

fun NavGraphBuilder.categoryScreen() {
    composable(route = categoryRoute) {
        CategoryRoute()
    }
}
