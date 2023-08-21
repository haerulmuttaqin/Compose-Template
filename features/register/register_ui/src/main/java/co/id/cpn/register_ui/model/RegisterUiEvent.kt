package co.id.cpn.register_ui.model

sealed class RegisterUiEvent {
    data class StoreIdChanged(val inputValue: String) : RegisterUiEvent()
    data class StoreAddressChanged(val inputValue: String) : RegisterUiEvent()
    data class PhoneNumberChanged(val inputValue: String) : RegisterUiEvent()
    data class OwnerNameChanged(val inputValue: String) : RegisterUiEvent()
    data class EmailAddressChanged(val inputValue: String) : RegisterUiEvent()
    data class StorePictureChanged(val inputValue: String) : RegisterUiEvent()
    object Submit : RegisterUiEvent()
}