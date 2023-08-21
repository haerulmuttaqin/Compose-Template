package co.id.cpn.sadixoo.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.id.cpn.sadixoo.navigation.AppNavHost
import co.id.cpn.sadixoo.component.BottomBar

@Composable
internal fun AppRoute() {
    AppScreen()
}


@Composable
fun AppScreen(
    appState: AppState = rememberAppState()
) {
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .imePadding()
            .statusBarsPadding(),
        bottomBar = {
            AnimatedVisibility(
                visible = appState.shouldShowBottomBar,
                enter =
                slideInVertically(
                    initialOffsetY = {it / 2},
                    animationSpec = tween( delayMillis = 500 )
                ) + fadeIn(
                    animationSpec = tween( delayMillis = 500 )
                ),
                exit = slideOutVertically(
                    targetOffsetY = {it / 2},
                ) + fadeOut()
            ) {
                BottomBar(
                    destinations = appState.topLevelDestinations,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination,
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            AppNavHost(appState.navController)
        }
    }
}