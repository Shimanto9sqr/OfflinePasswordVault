package com.example.passwordvault.presentation.screens.change_password

import androidx.annotation.StringRes

sealed interface ChangePasswordError {
    data class CurrentPasswordError(@StringRes val error: Int) : ChangePasswordError
    data class NewPasswordError(@StringRes val error: Int) : ChangePasswordError
}
