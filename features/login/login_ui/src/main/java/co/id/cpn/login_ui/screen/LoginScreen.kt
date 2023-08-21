package co.id.cpn.login_ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import co.id.cpn.login_ui.model.LoginUiEvent
import co.id.cpn.ui.component.button.ButtonLarge
import co.id.cpn.ui.component.input.InputField
import co.id.cpn.ui.component.input.InputPassword
import co.id.cpn.ui.component.input.InputPhone
import co.id.cpn.ui.component.input.InputPin
import co.id.cpn.ui.component.text.TextClickableColorize
import co.id.cpn.ui.component.text.TextClickableUnderline
import co.id.cpn.ui.compositions.AppComponent
import co.id.cpn.ui.theme.AppTheme
import co.id.cpn.ui.theme.ColorSystem
import co.id.cpn.ui.theme.SpaceDim
import com.mxalbert.sharedelements.SharedElement
import com.mxalbert.sharedelements.SharedElementsRoot
import co.id.cpn.common.R as commonR

@Composable
internal fun LoginRoute(
    onRegisterClick: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    LoginScreen(
        onRegisterClick = onRegisterClick,
        onNavigateToHome = onNavigateToHome
    )
}

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onRegisterClick: () -> Unit = {},
    onNavigateToHome: () -> Unit = {},
) {
    val state by viewModel.state.collectAsState()
    if (state.isLoginSuccessful) {
        LaunchedEffect(key1 = true) {
            onNavigateToHome.invoke()
        }
    } else {
        val isDark = !MaterialTheme.colors.isLight
        val imageLogo =
            if (isDark)
                painterResource(id = commonR.drawable.ic_sadix_logo_dark)
            else
                painterResource(id = commonR.drawable.ic_sadix_logo)

        Column(
            Modifier
                .fillMaxHeight()
                .navigationBarsPadding()
                .imePadding()
                .statusBarsPadding()
                .verticalScroll(rememberScrollState()),
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier
                    .padding(SpaceDim.current.spaceMedium)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                AppComponent.BigSpacer()
                Column(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally),
                ) {
                    SharedElement(
                        key = "sadix_logo",
                        screenKey = "sadix_logo_login"
                    ) {
                        Column {
                            Image(
                                modifier = Modifier
                                    .width(260.dp),
                                painter = imageLogo,
                                contentDescription = stringResource(id = commonR.string.app_name)
                            )
                            Text(
                                modifier = Modifier
                                    .align(alignment = Alignment.End)
                                    .padding(top = 7.dp),
                                text = stringResource(id = commonR.string.alt_name),
                                color = ColorSystem.BlueLight500
                            )
                        }
                    }
                }
                AppComponent.BigSpacer()
                InputPhone(
                    value = state.phone,
                    placeholder = stringResource(id = commonR.string.phone_number),
                    icon = Icons.Outlined.Phone,
                    imeAction = ImeAction.Next,
                    isError = state.errorState.phoneErrorState.hasError,
                    errorText = stringResource(id = state.errorState.phoneErrorState.errorMessageStringResource),
                    onValueChange = {
                        viewModel.onUiEvent(
                            loginUiEvent = LoginUiEvent.PhoneChanged(it)
                        )
                    }
                )
                InputPin(
                    value = state.pin,
                    placeholder = stringResource(id = commonR.string.pin),
                    isError = state.errorState.pinErrorState.hasError,
                    errorText = stringResource(id = state.errorState.pinErrorState.errorMessageStringResource),
                    onValueChange = {
                        viewModel.onUiEvent(
                            loginUiEvent = LoginUiEvent.PinChanged(it)
                        )
                    }
                )
                TextClickableUnderline(
                    text = stringResource(id = commonR.string.forgot_pin),
                    onClick = {}
                )
                AppComponent.BigSpacer()
                ButtonLarge(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = commonR.string.txt_login),
                    onClick = {
                        viewModel.onUiEvent(loginUiEvent = LoginUiEvent.Submit)
                    }
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            TextClickableColorize(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                text = "Don't have an account?",
                textColorize = "Register",
                onClick = onRegisterClick
            )
            AppComponent.BigSpacer()
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    AppTheme {
        SharedElementsRoot {
            LoginScreen()
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LoginDarkPreview() {
    AppTheme {
        SharedElementsRoot {
            LoginScreen()
        }
    }
}
