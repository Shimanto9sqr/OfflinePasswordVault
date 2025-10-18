package com.example.passwordvault.presentation.screens.manage_categories.event

sealed class ManageCategoriesUiEffect {
    data object ScrollToTop : ManageCategoriesUiEffect()
    data class NavigateToCategoryItem(val id: Int) : ManageCategoriesUiEffect()
    data object NavigateToAddCategory : ManageCategoriesUiEffect()
    data object NavigateUp : ManageCategoriesUiEffect()
}
