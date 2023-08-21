package co.id.cpn.login_ui.screen

import androidx.lifecycle.ViewModel
import co.id.cpn.common.models.ErrorState
import co.id.cpn.login_ui.model.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import timber.log.Timber

class LoginViewModel: ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    private fun setState(stateValue: LoginState) {
        _state.value = stateValue
    }

    fun onUiEvent(loginUiEvent: LoginUiEvent) {
        when (loginUiEvent) {
            // Email/Mobile changed
            is LoginUiEvent.PhoneChanged -> {
                setState(
                    state.value.copy(
                        phone = loginUiEvent.inputValue,
                        errorState = state.value.errorState.copy(
                            phoneErrorState = if (loginUiEvent.inputValue.toString().trim().isNotEmpty())
                                ErrorState()
                            else
                                phoneEmptyErrorState
                        )
                    )
                )
            }

            // Password changed
            is LoginUiEvent.PinChanged -> {
                setState(
                    state.value.copy(
                        pin = loginUiEvent.inputValue,
                        errorState = state.value.errorState.copy(
                            pinErrorState = if (loginUiEvent.inputValue.trim().isNotEmpty())
                                ErrorState()
                            else
                                pinEmptyErrorState
                        )
                    )
                )
            }

            // Submit Login
            is LoginUiEvent.Submit -> {
                val inputsValidated = validateInputs()
                if (inputsValidated) {
                    // TODO Trigger login in authentication flow
                    setState(
                        state.value.copy(isLoginSuccessful = true)
                    )
                }
            }
        }
    }

    private fun validateInputs(): Boolean {
        val phone = state.value.phone.trim()
        val pin = state.value.pin
        return when {

            // Email/Mobile empty
            phone.isEmpty() && phone.length <= 8  -> {
                setState(
                    state.value.copy(
                        errorState = LoginErrorState(
                            phoneErrorState = phoneEmptyErrorState
                        )
                    )
                )
                false
            }

            //Password Empty
            pin.isEmpty() && pin.length <= 6  -> {
                setState(
                    state.value.copy(
                        errorState = LoginErrorState(
                            pinErrorState = pinEmptyErrorState
                        )
                    )
                )
                false
            }

            // No errors
            else -> {
                // Set default error state
                setState(
                    state.value.copy(errorState = LoginErrorState())
                )
                true
            }
        }
    }
}
