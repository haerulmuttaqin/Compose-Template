package co.id.cpn.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Colors.composeThemeColor: Color
    @Composable get() = Color(0xFF4285f4)

val Colors.inputBackground: Color
    @Composable get() = if (isLight) ColorSystem.Gray150 else ColorSystem.Gray800

val Colors.onInputBackground: Color
    @Composable get() = if (isLight) ColorSystem.Gray900 else ColorSystem.Gray50

val Colors.errorInputBackground: Color
    @Composable get() = if (isLight) ColorSystem.Red500.copy(.1f) else ColorSystem.Red900.copy(.95f)

object AppColor {
//    val ExampleColor = Color(0xff123456)
}

object FlatColor {
    // Color from: https://flatuicolors.com/palette/defo
    val FlatAwesomeGreen1 = Color(0xFF1abc9c)
    val FlatAwesomeGreen2 = Color(0xFF16a085)
    val FlatGreen1 = Color(0xFF2ecc71)
    val FlatGreen2 = Color(0xFF27ae60)
    val FlatBlue1 = Color(0xFF3498db)
    val FlatBlue2 = Color(0xFF2980b9)
    val FlatPink1 = Color(0xFF9b59b6)
    val FlatGreyDark1 = Color(0xFF34495e)
    val FlatGreyDark2 = Color(0xFF2c3e50)
    val FlatGreyNormal1 = Color(0xFF95a5a6)
    val FlatGreyNormal2 = Color(0xFF7f8c8d)
    val FlatGreyLight1 = Color(0xFFecf0f1)
    val FlatGreyLight2 = Color(0xFFbdc3c7)
    val FlatRed1 = Color(0xFFe74c3c)
    val FlatRed2 = Color(0xFFc0392b)
    val FlatOrange1 = Color(0xFFe67e22)
    val FlatOrange2 = Color(0xFFd35400)
    val FlatYellow1 = Color(0xFFf1c40f)
    val FlatYellow2 = Color(0xFFf39c12)
}

object ColorSystem {
    // Color from: https://tailwindcss.com/docs/customizing-colors

    // colors.trueGray
    val Gray50 = Color(0xFFFAFAFA)
    val Gray100 = Color(0xFFF5F5F5)
    val Gray150 = Color(0xFFEEEEEE)
    val Gray200 = Color(0xFFE5E5E5)
    val Gray300 = Color(0xFFD4D4D4)
    val Gray400 = Color(0xFFA3A3A3)
    val Gray500 = Color(0xFF737373)
    val Gray600 = Color(0xFF525252)
    val Gray700 = Color(0xFF404040)
    val Gray800 = Color(0xFF262626)
    val Gray900 = Color(0xFF171717)

    // colors.red
    val Red500 = Color(0xFFEF4444)
    val Red700 = Color(0xFFB91C1C)
    val Red900 = Color(0xFF7F1D1D)

    // colors.amber
    val Yellow500 = Color(0xFFF59E0B)
    val Yellow700 = Color(0xFFB45309)
    val Yellow900 = Color(0xFF78350F)

    // colors.emerald
    val Green500 = Color(0xFF10B981)
    val Green700 = Color(0xFF047857)
    val Green900 = Color(0xFF064E3B)

    // colors.bluelight
    val BlueLight500 = Color(0xFF41A0C5)

    // colors.blue
    val Blue300 = Color(0xFF3B82F6)
    val Blue500 = Color(0xFF0C49B3)
    val Blue700 = Color(0xFF06346C)
    val Blue900 = Color(0xFF042C5C)

    // colors.indigo
    val Indigo500 = Color(0xFF6366F1)
    val Indigo700 = Color(0xFF4338CA)
    val Indigo900 = Color(0xFF312E81)

    // colors.violet
    val Purple500 = Color(0xFF8B5CF6)
    val Purple700 = Color(0xFF6D28D9)
    val Purple900 = Color(0xFF4C1D95)

    // colors.pink
    val Pink500 = Color(0xFFEC4899)
    val Pink700 = Color(0xFFBE185D)
    val Pink900 = Color(0xFF831843)
}
