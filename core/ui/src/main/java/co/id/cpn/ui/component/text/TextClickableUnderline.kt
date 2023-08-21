package co.id.cpn.ui.component.text

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import co.id.cpn.ui.theme.AppTheme
import co.id.cpn.ui.theme.ColorSystem

@Composable
fun TextClickableUnderline(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = ColorSystem.Gray400,
    onClick: (Int) -> Unit,
) {
    ClickableText(
        modifier = modifier,
        text = AnnotatedString(
            text = text
        ),
        style = TextStyle(
            textDecoration = TextDecoration.Underline,
            color = color
        ),
        onClick = onClick
    )
}

@Preview
@Composable
fun TextClickableUnderlinePreview() {
    AppTheme {
        TextClickableUnderline(
            modifier = Modifier,
            text = stringResource(id = co.id.cpn.common.R.string.txt_forgot_password),
            onClick = {}
        )
    }
}