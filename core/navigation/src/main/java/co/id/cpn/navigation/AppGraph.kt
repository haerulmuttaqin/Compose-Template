package co.id.cpn.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface AppGraph {
    fun registerGraph(
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    )
}