package co.id.cpn.register_ui.model

import co.id.cpn.common.models.ErrorState

data class RegisterState(
    val storeId: String = "",
    val ownerName: String = "",
    val storeAddress: String = "",
    val phoneNumber: String = "",
    val emailAddress: String = "",
    val storePicture: String = "",
    val errorState: RegisterErrorState = RegisterErrorState(),
    val isLoginSuccessful: Boolean = false
)

data class RegisterErrorState(
    val storeIdErrorState: ErrorState = ErrorState(),
    val ownerNameErrorState: ErrorState = ErrorState(),
    val storeAddressErrorState: ErrorState = ErrorState(),
    val phoneNumberErrorState: ErrorState = ErrorState(),
    val emailAddressErrorState: ErrorState = ErrorState(),
    val storePictureErrorState: ErrorState = ErrorState(),
)