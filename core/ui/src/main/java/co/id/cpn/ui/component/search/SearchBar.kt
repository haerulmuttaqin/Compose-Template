package co.id.cpn.ui.component.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.id.cpn.common.R
import co.id.cpn.ui.theme.AppTheme
import co.id.cpn.ui.theme.inputBackground
import com.mxalbert.sharedelements.SharedElement
import com.mxalbert.sharedelements.SharedElementsRoot

@Composable
fun SearchBarUI(
    searchText: String,
    placeholderText: String = "",
    onSearchTextChanged: (String) -> Unit = {},
    onClearClick: () -> Unit = {},
    onNavigateBack: () -> Unit = {},
    matchesFound: Boolean,
    results: @Composable () -> Unit = {}
) {

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            SearchBar(
                searchText,
                placeholderText,
                onSearchTextChanged,
                onClearClick,
                onNavigateBack
            )

            if (matchesFound) {
                Text("Results", modifier = Modifier.padding(8.dp), fontWeight = FontWeight.Bold)
                results()
            } else {
                if (searchText.isNotEmpty()) {
                    NoSearchResults()
                }

            }
        }

    }
}

@Composable
fun SearchBar(
    searchText: String,
    placeholderText: String = "",
    onSearchTextChanged: (String) -> Unit = {},
    onClearClick: () -> Unit = {},
    onNavigateBack: () -> Unit = {},
    elevation: Dp = 0.dp
) {
    var showClearButton by remember { mutableStateOf(searchText.isNotEmpty()) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }
    val interactionSource = remember { MutableInteractionSource() }

    TopAppBar(
        modifier = Modifier,
        title = { Text("") },
        backgroundColor = MaterialTheme.colors.surface,
        elevation = elevation,
        navigationIcon = {
            IconButton(onClick = { onNavigateBack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    modifier = Modifier,
                    contentDescription = stringResource(id = R.string.back)
                )
            }
        }, actions = {
            SharedElement(key = "search_bar", screenKey = "search_bar_screen") {
                Box(modifier = Modifier.padding(top = 6.dp, bottom = 6.dp, end = 8.dp)) {
                    BasicTextField(
                        value = searchText,
                        onValueChange = {
                            onSearchTextChanged(it)
                            showClearButton = it.isNotEmpty()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = MaterialTheme.colors.inputBackground,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .focusRequester(focusRequester),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                keyboardController?.hide()
                            },
                            onSearch = {
                                keyboardController?.hide()

                            }
                        ),
                    ) {
                        TextFieldDefaults.TextFieldDecorationBox(
                            value = searchText,
                            innerTextField = it,
                            singleLine = true,
                            enabled = true,
                            visualTransformation = VisualTransformation.None,
                            trailingIcon = {
                                this@TopAppBar.AnimatedVisibility(
                                    visible = showClearButton,
                                    enter = fadeIn(),
                                    exit = fadeOut()
                                ) {
                                    IconButton(
                                        onClick = {
                                            onClearClick()
                                            showClearButton = false
                                        }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.Close,
                                            contentDescription = stringResource(id = R.string.clear)
                                        )
                                    }
                                }
                            },
                            placeholder = {Text(text = placeholderText) },
                            interactionSource = interactionSource,
                            // change the padding
                            contentPadding = TextFieldDefaults.textFieldWithoutLabelPadding(
                                top = 2.dp, bottom = 2.dp
                            )
                        )
                    }
//                    OutlinedTextField(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .focusRequester(focusRequester),
//                        value = "searchText",
//                        onValueChange = {
//                            onSearchTextChanged(it)
//                            showClearButton = it.isNotEmpty()
//                        },
//                        placeholder = {
//                            Text(text = placeholderText)
//                        },
//                        colors = TextFieldDefaults.textFieldColors(
//                            focusedIndicatorColor = Color.Transparent,
//                            unfocusedIndicatorColor = Color.Transparent,
//                            backgroundColor = MaterialTheme.colors.inputBackground,
//                            cursorColor = MaterialTheme.colors.primaryVariant
//                        ),
//                        shape = RoundedCornerShape(8.dp),
//                        trailingIcon = {
//                            this@TopAppBar.AnimatedVisibility(
//                                visible = showClearButton,
//                                enter = fadeIn(),
//                                exit = fadeOut()
//                            ) {
//                                IconButton(
//                                    onClick = {
//                                        onClearClick()
//                                        showClearButton = false
//                                    }
//                                ) {
//                                    Icon(
//                                        imageVector = Icons.Filled.Close,
//                                        contentDescription = stringResource(id = R.string.clear)
//                                    )
//                                }
//                            }
//                        },
//                        maxLines = 1,
//                        singleLine = true,
//                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
//                        keyboardActions = KeyboardActions(onDone = {
//                            keyboardController?.hide()
//                        }),
//                    )
                }
            }
        })


    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}


@Composable
fun NoSearchResults() {

    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {

        Text("No matches found")

    }
}

@Preview
@Composable
fun PreviewSearchBar() {
    AppTheme {
        SharedElementsRoot {
            SearchBarUI(searchText = "", matchesFound = false, placeholderText = "Search")
        }
    }
}