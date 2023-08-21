package co.id.cpn.register_ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import co.id.cpn.common.R
import co.id.cpn.register_ui.model.RegisterUiEvent
import co.id.cpn.ui.component.button.ButtonLarge
import co.id.cpn.ui.component.input.InputField
import co.id.cpn.ui.component.input.InputPhone
import co.id.cpn.ui.component.text.TextClickableColorize
import co.id.cpn.ui.compositions.AppComponent
import co.id.cpn.ui.theme.AppTheme
import co.id.cpn.ui.theme.SpaceDim
import com.mxalbert.sharedelements.SharedElement
import com.mxalbert.sharedelements.SharedElementsRoot

@Composable
internal fun RegisterRoute(
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel = hiltViewModel(),
) {
    RegisterScreen(
        onLoginClick = onLoginClick,
    )
}

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = hiltViewModel(),
    onLoginClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {},
) {

//    val state by remember {
//        viewModel.state
//    }

    val state by viewModel.state.collectAsState()

    val isDark = !MaterialTheme.colors.isLight
    val imageLogo =
        if (isDark)
            painterResource(id = R.drawable.ic_sadix_logo_dark)
        else
            painterResource(id = R.drawable.ic_sadix_logo)

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

            SharedElement(key = "sadix_logo", screenKey = "sadix_logo_register") {
                Column(
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                ) {
                    Image(
                        modifier = Modifier
                            .width(210.dp),
                        painter = imageLogo,
                        contentDescription = stringResource(id = R.string.app_name)
                    )
                }
            }

            AppComponent.BigSpacer()
            Text(
                modifier = Modifier
                    .padding(top = 7.dp),
                text = stringResource(id = R.string.txt_register),
                style = MaterialTheme.typography.h1,
            )
            Text(
                text = stringResource(id = R.string.please_input_information),
                style = MaterialTheme.typography.body1,
            )
            AppComponent.BigSpacer()

            InputField(
                value = state.storeId,
                placeholder = stringResource(id = R.string.store_id),
                keyboardType = KeyboardType.Text,
                keyboardCapitalization = KeyboardCapitalization.Characters,
                imeAction = ImeAction.Next,
                isError = state.errorState.storeIdErrorState.hasError,
                errorText = stringResource(id = state.errorState.storeIdErrorState.errorMessageStringResource),
                onValueChange = {
                    viewModel.onUiEvent(
                        event = RegisterUiEvent.StoreIdChanged(it)
                    )
                }
            )

            InputField(
                value = state.ownerName,
                placeholder = stringResource(id = R.string.owner_name),
                keyboardType = KeyboardType.Text,
                keyboardCapitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next,
                isError = state.errorState.ownerNameErrorState.hasError,
                errorText = stringResource(id = state.errorState.ownerNameErrorState.errorMessageStringResource),
                onValueChange = {
                    viewModel.onUiEvent(
                        event = RegisterUiEvent.OwnerNameChanged(it)
                    )
                }
            )

            InputPhone(
                value = state.phoneNumber,
                placeholder = stringResource(id = R.string.phone_number),
                imeAction = ImeAction.Next,
                isError = state.errorState.phoneNumberErrorState.hasError,
                errorText = stringResource(id = state.errorState.phoneNumberErrorState.errorMessageStringResource),
                onValueChange = {
                    viewModel.onUiEvent(
                        event = RegisterUiEvent.PhoneNumberChanged(it)
                    )
                }
            )

            InputField(
                value = state.emailAddress,
                placeholder = stringResource(id = R.string.email_address),
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
                isError = state.errorState.emailAddressErrorState.hasError,
                errorText = stringResource(id = state.errorState.emailAddressErrorState.errorMessageStringResource),
                onValueChange = {
                    viewModel.onUiEvent(
                        event = RegisterUiEvent.EmailAddressChanged(it)
                    )
                }
            )

            AppComponent.BigSpacer()
            ButtonLarge(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.txt_register),
                onClick = {
                    viewModel.onUiEvent(event = RegisterUiEvent.Submit)
                }
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        TextClickableColorize(
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            text = "Already have an account?",
            textColorize = "Login",
            onClick = onLoginClick
        )
        AppComponent.BigSpacer()
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    AppTheme {
        SharedElementsRoot {
            RegisterScreen()
        }
    }
}