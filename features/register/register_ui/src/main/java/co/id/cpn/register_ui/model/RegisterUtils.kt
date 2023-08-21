package co.id.cpn.register_ui.model

import co.id.cpn.common.models.ErrorState
import co.id.cpn.common.R

val phoneEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.please_input_phone_number
)

val storeIdEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.please_input_store_id
)

val nameEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.please_input_your_name
)

val storeAddressEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.please_input_your_address
)

val emailEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.please_input_email
)

val photoEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.please_take_store_picture
)