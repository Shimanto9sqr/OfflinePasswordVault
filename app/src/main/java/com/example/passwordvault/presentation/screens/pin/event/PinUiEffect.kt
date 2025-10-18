package com.example.passwordvault.presentation.screens.pin.event

sealed class PinUiEffect {
    data object PinUpdated : PinUiEffect()
    data object NavigateUp : PinUiEffect()
}
