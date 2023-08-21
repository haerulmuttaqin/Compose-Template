package co.id.cpn.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val SpaceDim = compositionLocalOf { Dimensions() }
data class Dimensions(
    val default: Dp = 0.dp,
    val spaceXXSmall: Dp = 2.dp,
    val spaceExtraSmall: Dp = 4.dp,
    val spaceSmall: Dp = 8.dp,
    val spaceMedium: Dp = 16.dp,
    val spaceLarge: Dp = 32.dp,
    val spaceExtraLarge: Dp = 64.dp,
    val spaceXXLarge: Dp = 128.dp,
    val spaceXXXLarge: Dp = 256.dp,
)

val ElementDim = compositionLocalOf { Element() }
data class Element(
    val inputHeightMedium: Dp = 57.dp
)