package com.example.passwordvault.presentation.screens.pin

data class PinState(
    val pin: String = "",
    val usePin: Boolean = false,
    val hasPinSet: Boolean = false,
    val showPin: Boolean = false,
    val showDisablePinDialog: Boolean = false
)
