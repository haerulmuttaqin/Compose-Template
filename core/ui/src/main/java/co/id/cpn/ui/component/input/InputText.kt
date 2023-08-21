package co.id.cpn.ui.component.input

import androidx.compose.animation.*
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.id.cpn.common.R
import co.id.cpn.ui.compositions.AppComponent
import co.id.cpn.ui.theme.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun ModifierPreview() {
    AppTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            InputField(
                value = "",
                placeholder = "Username",
                isError = false,
                errorText = "Please input username"
            )
        }
    }
}

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    value: String,
    background: Color = MaterialTheme.colors.inputBackground,
    shape: Shape = RoundedCornerShape(9.dp),
    placeholder: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    readOnly: Boolean = false,
    singleLine: Boolean = true,
    maxLength: Int = Int.MAX_VALUE,
    maxLines: Int = 1,
    imeAction: ImeAction = ImeAction.Done,
    keyboardActions: KeyboardActions? = null,
    keyboardCapitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    height: Dp = ElementDim.current.inputHeightMedium,
    icon: ImageVector? = null,
    isError: Boolean = false,
    errorText: String = stringResource(id = R.string.empty_string),
    isEnabled: Boolean = true,
    onValueChange: (String) -> Unit = {}
) {
    val focusManager = LocalFocusManager.current
    val bringIntoViewRequester = remember { BringIntoViewRequester() }
    val interactionSource = remember { MutableInteractionSource() }
    val interactionSourceState = interactionSource.collectIsFocusedAsState()
    val scope = rememberCoroutineScope()
    val isImeVisible = WindowInsets.isImeVisible

    // Bring the composable into view (visible to user).
    LaunchedEffect(isImeVisible, interactionSourceState.value) {
        if (isImeVisible && interactionSourceState.value) {
            scope.launch {
                delay(300)
                bringIntoViewRequester.bringIntoView()
            }
        }
    }

    val focusRequester = FocusRequester()
    val isFocused = remember { mutableStateOf(false) }
    val isInputError = remember { mutableStateOf(false) }
    isInputError.value = isError

    Column {
        BasicTextField(
            modifier = modifier
                .focusRequester(focusRequester)
                .bringIntoViewRequester(bringIntoViewRequester)
                .onFocusChanged {
                    isFocused.value = it.isFocused
                }
                .fillMaxWidth(),
            interactionSource = interactionSource,
            value = value,
            enabled = isEnabled,
            singleLine = singleLine,
            maxLines = maxLines,
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontFamily = MaterialTheme.typography.body1.fontFamily,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colors.onInputBackground
            ),
            onValueChange = {
                if (it.length <= maxLength) {
                    isInputError.value = false
                    onValueChange(it)
                }
            },
            keyboardActions = keyboardActions ?: KeyboardActions(
                onDone = { focusManager.clearFocus() },
                onNext = { focusManager.moveFocus(FocusDirection.Down) },
                onSearch = { focusManager.clearFocus() }
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction,
                capitalization = keyboardCapitalization
            ),
            cursorBrush = SolidColor(MaterialTheme.colors.primaryVariant),
            readOnly = readOnly,
            decorationBox = { innerTextField ->
                Box(
                    if (!isInputError.value) {
                        Modifier
                            .clip(shape)
                            .background(if (isFocused.value) background.copy(alpha = .10f) else background)
                            .height(height)
                            .border(
                                width = if (isFocused.value) 2.dp else 0.dp,
                                color = if (isFocused.value) MaterialTheme.colors.primaryVariant else background,
                                shape = RoundedCornerShape(9.dp)
                            )
                    } else {
                        Modifier
                            .clip(shape)
                            .background(if (isFocused.value) background.copy(alpha = .10f) else background)
                            .height(height)
                            .border(
                                width = 2.dp,
                                color = ColorSystem.Red500,
                                shape = RoundedCornerShape(9.dp)
                            )
                    },
                ) {
                    Row(
                        Modifier.fillMaxSize()
                    ) {
                        icon?.let {
                            Icon(
                                imageVector = icon,
                                modifier = Modifier
                                    .size(height = height, width = 48.dp)
                                    .padding(12.dp),
                                contentDescription = null,
                                tint = ColorSystem.Gray400
                            )
                        }

                        Box(
                            Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .padding(
                                    start = if (icon == null) 15.dp else 0.dp,
                                    bottom = 0.dp,
                                    end = 15.dp
                                )
                        ) {
                            val hasText = value.isNotEmpty()

                            val animPlaceholder: Dp by animateDpAsState(
                                if (isFocused.value || hasText) 7.dp else 18.dp
                            )
                            val animPlaceHolderFontSize: Int by animateIntAsState(
                                if (isFocused.value || hasText) 11 else 14
                            )

                            if (!isInputError.value) {
                                Text(
                                    modifier = Modifier
                                        .graphicsLayer {
                                            translationY = animPlaceholder.toPx()
                                        },
                                    text = placeholder,
                                    color = if (isFocused.value) MaterialTheme.colors.primaryVariant
                                    else MaterialTheme.colors.onInputBackground.copy(alpha = .35f),
                                    fontSize = animPlaceHolderFontSize.sp,
                                    fontFamily = MaterialTheme.typography.body1.fontFamily,
                                    maxLines = if (singleLine) 1 else Int.MAX_VALUE,
                                    overflow = TextOverflow.Ellipsis
                                )
                            } else {
                                Text(
                                    modifier = Modifier
                                        .graphicsLayer {
                                            translationY = animPlaceholder.toPx()
                                        },
                                    text = placeholder,
                                    color = ColorSystem.Red500,
                                    fontSize = animPlaceHolderFontSize.sp,
                                    fontFamily = MaterialTheme.typography.body1.fontFamily,
                                    maxLines = if (singleLine) 1 else Int.MAX_VALUE,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            Column(
                                Modifier
                                    .padding(top = 24.dp)
                                    .fillMaxWidth()
                            ) {
                                innerTextField()
                            }
                        }
                    }
                }
            }
        )
        AnimatedVisibility(
            visible = isInputError.value,
            enter = slideInVertically() + fadeIn(),
            exit = slideOutVertically() + fadeOut()
        ) {
            Row(modifier = Modifier.padding(top = 5.dp)) {
                Icon(
                    modifier = Modifier.size(14.dp).padding(),
                    imageVector = Icons.Default.Error,
                    contentDescription = "",
                    tint = ColorSystem.Red500
                )
                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = errorText,
                    color = ColorSystem.Red500,
                    fontSize = 11.sp,
                    fontFamily = MaterialTheme.typography.body1.fontFamily,
                )
            }
        }
        AppComponent.MediumSpacer()
    }
}