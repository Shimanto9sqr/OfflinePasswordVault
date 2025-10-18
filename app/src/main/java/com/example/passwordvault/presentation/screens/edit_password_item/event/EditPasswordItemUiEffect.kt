package com.example.passwordvault.presentation.screens.edit_password_item.event

sealed class EditPasswordItemUiEffect {
    data object EditComplete : EditPasswordItemUiEffect()
    data object NavigateToAddCategory : EditPasswordItemUiEffect()
    data object NavigateUp : EditPasswordItemUiEffect()
}
