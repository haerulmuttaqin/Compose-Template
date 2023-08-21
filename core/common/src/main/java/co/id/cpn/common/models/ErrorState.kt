package co.id.cpn.common.models

import androidx.annotation.StringRes
import co.id.cpn.common.R

/**
 * Error state holding values for error ui
 */
data class ErrorState(
    val hasError: Boolean = false,
    @StringRes val errorMessageStringResource: Int = R.string.empty_string
)