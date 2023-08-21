package co.id.cpn.login_ui.model

import co.id.cpn.common.models.ErrorState
import co.id.cpn.common.R

val phoneEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.please_input_phone_number
)

val pinEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.please_input_pin
)

val isButtonEnabledState = ErrorState(
    hasError = true
)