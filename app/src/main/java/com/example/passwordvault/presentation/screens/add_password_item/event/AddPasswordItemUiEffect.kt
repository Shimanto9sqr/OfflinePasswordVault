package com.example.passwordvault.presentation.screens.add_password_item.event

sealed class AddPasswordItemUiEffect {
    data object NavigateToAddCategory : AddPasswordItemUiEffect()
    data object NavigateUp : AddPasswordItemUiEffect()
}
