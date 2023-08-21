package co.id.cpn.sadixoo.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import co.id.cpn.account_ui.navigation.accountRoute
import co.id.cpn.account_ui.navigation.navigateToAccount
import co.id.cpn.category_ui.navigation.categoryRoute
import co.id.cpn.category_ui.navigation.navigateToCategory
import co.id.cpn.point_ui.navigation.navigateToPoint
import co.id.cpn.point_ui.navigation.pointRoute
import co.id.cpn.sadixoo.model.AppNavDestination
import co.id.cpn.sadixoo.ui.screens.home.navigation.homeRoute
import co.id.cpn.sadixoo.ui.screens.home.navigation.navigateToHome
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): AppState {
    return remember(navController, coroutineScope) {
        AppState(navController, coroutineScope)
    }
}

@Stable
class AppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val shouldShowBottomBar: Boolean
        @Composable get() = when (currentDestination?.route) {
            homeRoute,
            categoryRoute,
            pointRoute,
            accountRoute -> true
            else -> false
        }

    val topLevelDestinations: List<AppNavDestination> = AppNavDestination.values().asList()

    fun navigateToTopLevelDestination(topLevelDestination: AppNavDestination) {
        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

        when (topLevelDestination) {
            AppNavDestination.HOME -> navController.navigateToHome(topLevelNavOptions)
            AppNavDestination.CATEGORY -> navController.navigateToCategory(topLevelNavOptions)
            AppNavDestination.POINT -> navController.navigateToPoint(topLevelNavOptions)
            AppNavDestination.ACCOUNT -> navController.navigateToAccount(topLevelNavOptions)
        }
    }
}