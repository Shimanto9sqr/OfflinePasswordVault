package com.example.passwordvault.presentation.screens.password_lock


data class PasswordLockState(
    val showPassword: Boolean = false,
    val showConfirmPassword: Boolean = false,
    val password: String = "",
    val confirmPassword: String = "",
    val hasPinSet: Boolean? = null,
    val hasPasswordSet: Boolean? = null,
    val useScreenLockToUnlock: Boolean? = null,
    val isScreenLockAvailable: Boolean? = null
)
