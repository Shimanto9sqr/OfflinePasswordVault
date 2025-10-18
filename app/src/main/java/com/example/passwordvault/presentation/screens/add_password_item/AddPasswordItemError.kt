package com.example.passwordvault.presentation.screens.add_password_item

import androidx.annotation.StringRes

sealed interface AddPasswordItemError {
    data class NameError(@StringRes val error: Int) : AddPasswordItemError
}
