package com.example.passwordvault.presentation.screens.password_lock.event

sealed class PasswordLockUiEffect {
    data object FocusPasswordField : PasswordLockUiEffect()
    data object HideKeyboard : PasswordLockUiEffect()
    data object BiometricAuthenticate : PasswordLockUiEffect()
}
