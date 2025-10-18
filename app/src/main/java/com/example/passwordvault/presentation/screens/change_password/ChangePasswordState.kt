package com.example.passwordvault.presentation.screens.change_password


data class ChangePasswordState(
    val currentPassword: String = "",
    val newPassword: String = "",
    val showPassword: Boolean = false,
    val showNewPassword: Boolean = false
)
