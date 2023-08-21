package co.id.cpn.sadixoo.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ManageAccounts
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Widgets
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector
import co.id.cpn.common.R

enum class AppNavDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    HOME(
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        iconTextId = R.string.nav_home,
        titleTextId = R.string.nav_home
    ),
    CATEGORY(
        selectedIcon = Icons.Filled.Widgets,
        unselectedIcon = Icons.Outlined.Widgets,
        iconTextId = R.string.nav_category,
        titleTextId = R.string.nav_category
    ),
    POINT(
        selectedIcon = Icons.Filled.Star,
        unselectedIcon = Icons.Outlined.Grade,
        iconTextId = R.string.nav_point,
        titleTextId = R.string.nav_point
    ),
    ACCOUNT(
        selectedIcon = Icons.Filled.ManageAccounts,
        unselectedIcon = Icons.Outlined.ManageAccounts,
        iconTextId = R.string.nav_account,
        titleTextId = R.string.nav_account
    )
}