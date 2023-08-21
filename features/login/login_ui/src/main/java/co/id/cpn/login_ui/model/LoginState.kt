package co.id.cpn.login_ui.model

import co.id.cpn.common.models.ErrorState

data class LoginState(
    val phone: String = "",
    val pin: String = "",
    val errorState: LoginErrorState = LoginErrorState(),
    val isLoginSuccessful: Boolean = false
)

data class LoginErrorState(
    val phoneErrorState: ErrorState = ErrorState(),
    val pinErrorState: ErrorState = ErrorState()
)