package com.example.passwordvault.presentation.screens.edit_password_item

import androidx.annotation.StringRes

sealed interface EditPasswordItemError {
    data class NameError(@StringRes val error: Int) : EditPasswordItemError
}
