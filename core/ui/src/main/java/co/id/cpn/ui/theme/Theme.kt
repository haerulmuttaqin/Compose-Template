package co.id.cpn.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = ColorSystem.Blue300,
    primaryVariant = ColorSystem.BlueLight500,
    secondary = ColorSystem.Pink700,
    secondaryVariant = ColorSystem.Pink900,
    background = ColorSystem.Gray900,
    surface = Color.Black,
    error = ColorSystem.Red700,

    onPrimary = ColorSystem.Gray50,
    onSecondary = ColorSystem.Gray50,
    onBackground = ColorSystem.Gray50,
    onSurface = ColorSystem.Gray50,
)

private val LightColorPalette = lightColors(
    primary = ColorSystem.Blue500,
    primaryVariant = ColorSystem.Blue700,
    secondary = ColorSystem.Pink500,
    secondaryVariant = ColorSystem.Pink700,
    background = ColorSystem.Gray50,
    surface = Color.White,
    error = ColorSystem.Red500,

    onPrimary = ColorSystem.Gray50,
    onSecondary = ColorSystem.Gray50,
    onBackground = ColorSystem.Gray900,
    onSurface = ColorSystem.Gray900
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = !darkTheme
        )
    }

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
