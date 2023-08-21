package co.id.cpn.sadixoo.ui.screens.welcome

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.id.cpn.sadixoo.ui.screens.home.HomeScreen
import co.id.cpn.ui.theme.AppTheme
import kotlinx.coroutines.delay
import kotlin.random.Random
import co.id.cpn.common.R as commonR

@Composable
internal fun WelcomeRoute(gotoHomeIndex: () -> Unit = {}) {
    WelcomeScreen(gotoHomeIndex = gotoHomeIndex)
}

@Composable
fun WelcomeScreen(
    gotoHomeIndex: () -> Unit = {}
) {
    val isDark = !MaterialTheme.colors.isLight

    LaunchedEffect(Unit) {
        delay(2000)
        gotoHomeIndex()
    }

    Scaffold { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var state by remember { mutableStateOf(false) }

            LaunchedEffect(Unit) {
                val startDelay = Random.nextLong(300, 900)
                delay(startDelay)
                state = true
            }

            val animAlpha by animateFloatAsState(
                targetValue = if (state) 1f else 0f,
                animationSpec = tween(
                    durationMillis = 900,
                    easing = FastOutSlowInEasing
                )
            )

            val animRotation by animateFloatAsState(
                targetValue = if (state) 0f else -10f,
                animationSpec = tween(
                    durationMillis = 800,
                    easing = FastOutSlowInEasing
                )
            )

            val animScale by animateFloatAsState(
                targetValue = if (state) 1f else 0.8f,
                animationSpec = tween(
                    durationMillis = 800,
                    easing = FastOutSlowInEasing
                )
            )
            
            Spacer(modifier = Modifier.height(55.dp))

            Image(
                modifier = Modifier
                    .weight(1f)
                    .height(110.dp)
                    .width(210.dp)
                    .graphicsLayer {
                        alpha = animAlpha
                        scaleX = animScale
                        scaleY = animScale
                        translationY = animRotation
                    },
                painter = painterResource(id = if (isDark) commonR.drawable.ic_sadix_logo_dark else commonR.drawable.ic_sadix_logo),
                contentDescription = stringResource(id = commonR.string.app_name)
            )

            AnimatedText(
                text = stringResource(id = commonR.string.app_name),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 100.dp)
            )
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    AppTheme {
        WelcomeScreen()
    }
}

@Composable
fun AnimatedText(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        text.forEach { char ->

            var state by remember { mutableStateOf(false) }

            LaunchedEffect(char) {
                val startDelay = Random.nextLong(300, 800)
                delay(startDelay)
                state = true
            }

            val animAlpha by animateFloatAsState(
                targetValue = if (state) 0.8f else 0f,
                animationSpec = tween(
                    durationMillis = 800,
                    easing = FastOutSlowInEasing
                )
            )

            Text(
                text = char.toString(),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.graphicsLayer {
                    alpha = animAlpha
                }
            )
        }
    }
}
