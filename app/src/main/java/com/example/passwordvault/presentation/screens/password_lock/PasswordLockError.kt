package com.example.passwordvault.presentation.screens.password_lock

import androidx.annotation.StringRes

sealed interface PasswordLockError {
    data class PasswordError(@StringRes val error: Int) : PasswordLockError
    data class ConfirmPasswordError(@StringRes val error: Int) : PasswordLockError
}
