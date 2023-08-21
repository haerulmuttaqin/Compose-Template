package co.id.cpn.account_ui.screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AccountViewModel: ViewModel() {

    private val _state = MutableStateFlow(AccountState())
    val state = _state.asStateFlow()
}

class AccountState