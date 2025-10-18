package com.example.passwordvault.presentation.screens.manage_categories.event

sealed class ManageCategoriesUiEvent {
    data object ScrollToTop : ManageCategoriesUiEvent()
    data class NavigateToCategoryItem(val id: Int) : ManageCategoriesUiEvent()
    data object NavigateToAddCategory : ManageCategoriesUiEvent()
    data object NavigateUp : ManageCategoriesUiEvent()
}
