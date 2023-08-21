package co.id.cpn.ui.component.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.id.cpn.ui.theme.AppTheme

@Composable
fun ButtonMedium(
    modifier: Modifier = Modifier,
    text: String,
    @DrawableRes startIcon: Int? = null,
    @DrawableRes endIcon: Int? = null,
    height: Dp = 42.dp,
    fontSize: TextUnit = 16.sp,
    backgroundColor: Color = MaterialTheme.colors.primary,
    shape: Shape = MaterialTheme.shapes.medium,
    onClick: () -> Unit
) {
    val currentFocus = LocalFocusManager.current

    Button(
        modifier = modifier.height(height),
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor
        ),
        onClick = {
            currentFocus.clearFocus()

            onClick()
        }
    ) {
        if (startIcon != null) {
            Icon(
                painterResource(id = startIcon),
                contentDescription = text,
                modifier = Modifier.size(ButtonDefaults.IconSize),
                tint = Color.White
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        }

        Text(
            text,
            modifier = Modifier.padding(horizontal = 20.dp),
            style = MaterialTheme.typography.button,
            color = Color.White,
            fontSize = fontSize
        )

        if (endIcon != null) {
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Icon(
                painterResource(id = endIcon),
                contentDescription = text,
                modifier = Modifier.size(ButtonDefaults.IconSize),
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
fun ButtonMediumPreview() {
    AppTheme {
        ButtonMedium(text = "Login", onClick = {})
    }
}