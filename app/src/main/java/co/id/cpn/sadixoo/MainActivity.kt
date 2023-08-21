package co.id.cpn.sadixoo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.addCallback
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import co.id.cpn.common.extensions.toast
import co.id.cpn.common.utils.SharedPref
import co.id.cpn.common.utils.ThemeController
import co.id.cpn.sadixoo.navigation.AppNavHost
import co.id.cpn.sadixoo.navigation.RootNavHost
import co.id.cpn.ui.theme.AppTheme
import com.mxalbert.sharedelements.SharedElementsRoot
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var sharedPref: SharedPref
    private var pressBackExitJob: Job? = null
    private var backPressedOnce = false
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        ThemeController.updateUITheme(sharedPref.getDarkMode())

        setContent {
            val isDarkMode by ThemeController.isDarkMode.collectAsState()
            val navController = rememberNavController()

            AppTheme {
                SharedElementsRoot {
                    RootNavHost(
                        navController = navController,
                    )
                }
            }
        }

        // Press double back to exit
        onBackPressedDispatcher.addCallback(this) {
            pressBackExitJob?.cancel()

            if (backPressedOnce) {
                finish()
                return@addCallback
            }

            toast("Please press back again to exit.")

            backPressedOnce = true

            pressBackExitJob = lifecycleScope.launch {
                delay(1000)

                backPressedOnce = false
            }
        }
    }
}