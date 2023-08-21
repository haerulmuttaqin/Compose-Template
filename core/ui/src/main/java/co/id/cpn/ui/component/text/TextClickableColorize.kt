package co.id.cpn.ui.component.text

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import co.id.cpn.common.extensions.toast
import co.id.cpn.ui.theme.AppTheme
import co.id.cpn.ui.theme.ColorSystem

@Composable
fun TextClickableColorize(
    modifier: Modifier = Modifier,
    text: String,
    textColorize: String,
    color: Color = ColorSystem.Gray400,
    onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val scope = rememberCoroutineScope()

    val annotatedText = buildAnnotatedString {
        append(text)
        append(" ")

        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.primaryVariant,
                fontWeight = FontWeight.Bold
            )
        ) {
            append(textColorize)
        }
    }

    ClickableText(
        modifier = modifier.clickable {  },
        text = annotatedText,
        style = TextStyle(
            color = color
        ),
        onClick = {
            onClick.invoke()
        }
    )
}

@Preview
@Composable
fun TextClickableColorizePreview() {
    AppTheme {
        TextClickableColorize(
            modifier = Modifier,
            text = "Belum punya akun?",
            textColorize = "Daftar",
            onClick = {}
        )
    }
}