package co.id.cpn.login_ui.model

sealed class LoginUiEvent {
    data class PhoneChanged(val inputValue: String) : LoginUiEvent()
    data class PinChanged(val inputValue: String) : LoginUiEvent()
    object Submit : LoginUiEvent()
}