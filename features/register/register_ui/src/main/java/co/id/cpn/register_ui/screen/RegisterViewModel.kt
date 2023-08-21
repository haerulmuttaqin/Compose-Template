package co.id.cpn.register_ui.screen

import androidx.lifecycle.ViewModel
import co.id.cpn.common.models.ErrorState
import co.id.cpn.register_ui.model.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import timber.log.Timber

class RegisterViewModel: ViewModel() {
    private val _state = MutableStateFlow(RegisterState())
    val state = _state.asStateFlow()

    private fun setState(stateValue: RegisterState) {
        _state.value = stateValue
    }

    fun onUiEvent(event: RegisterUiEvent) {
        when (event) {
            // Email/Mobile changed
            is RegisterUiEvent.StoreIdChanged -> {
                setState(
                    state.value.copy(
                        storeId = event.inputValue,
                        errorState = state.value.errorState.copy(
                            storeIdErrorState = if (event.inputValue.trim().isNotEmpty())
                                ErrorState()
                            else
                                storeIdEmptyErrorState
                        )
                    )
                )
            }
            is RegisterUiEvent.OwnerNameChanged -> setState(
                state.value.copy(
                    ownerName = event.inputValue,
                    errorState = state.value.errorState.copy(
                        ownerNameErrorState = if (event.inputValue.trim().isNotEmpty())
                            ErrorState()
                        else
                            nameEmptyErrorState
                    )
                )
            )
            is RegisterUiEvent.PhoneNumberChanged -> setState(
                state.value.copy(
                    phoneNumber = event.inputValue,
                    errorState = state.value.errorState.copy(
                        phoneNumberErrorState = if (event.inputValue.trim().isNotEmpty())
                            ErrorState()
                        else
                            phoneEmptyErrorState
                    )
                )
            )
            is RegisterUiEvent.EmailAddressChanged -> setState(
                state.value.copy(
                    emailAddress = event.inputValue,
                    errorState = state.value.errorState.copy(
                        emailAddressErrorState = if (event.inputValue.trim().isNotEmpty())
                            ErrorState()
                        else
                            emailEmptyErrorState
                    )
                )
            )
            is RegisterUiEvent.StoreAddressChanged -> setState(
                state.value.copy(
                    storeAddress = event.inputValue,
                    errorState = state.value.errorState.copy(
                        storeAddressErrorState = if (event.inputValue.trim().isNotEmpty())
                            ErrorState()
                        else
                            emailEmptyErrorState
                    )
                )
            )
            is RegisterUiEvent.StorePictureChanged -> ErrorState()
            // Submit Login
            is RegisterUiEvent.Submit -> {
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

        val storeId = state.value.storeId.trim()
        val ownerName = state.value.ownerName.trim()
        val storeAddress = state.value.storeAddress.trim()
        val phoneNumber = state.value.phoneNumber.trim()
        val emailAddress = state.value.emailAddress.trim()

        return when {

            // Email/Mobile empty
            storeId.isEmpty() -> {
                setState(
                    state.value.copy(
                        errorState = RegisterErrorState(
                            storeIdErrorState = storeIdEmptyErrorState
                        )
                    )
                )
                false
            }
            ownerName.isEmpty() -> {
                setState(
                    state.value.copy(
                        errorState = RegisterErrorState(
                            ownerNameErrorState = nameEmptyErrorState
                        )
                    )
                )
                false
            }
            phoneNumber.isEmpty() -> {
                setState(
                    state.value.copy(
                        errorState = RegisterErrorState(
                            phoneNumberErrorState = phoneEmptyErrorState
                        )
                    )
                )
                false
            }
            emailAddress.isEmpty() -> {
                setState(
                    state.value.copy(
                        errorState = RegisterErrorState(
                            emailAddressErrorState = emailEmptyErrorState
                        )
                    )
                )
                false
            }
            storeAddress.isEmpty() -> {
                setState(
                    state.value.copy(
                        errorState = RegisterErrorState(
                            storeAddressErrorState = storeAddressEmptyErrorState
                        )
                    )
                )
                false
            }

            // No errors
            else -> {
                // Set default error state
                setState(
                    state.value.copy(errorState = RegisterErrorState())
                )
                true
            }
        }
    }
}
