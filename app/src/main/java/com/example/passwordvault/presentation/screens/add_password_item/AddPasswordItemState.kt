package com.example.passwordvault.presentation.screens.add_password_item

import com.example.passwordvault.domain.model.CategoryModel
import kotlinx.coroutines.flow.StateFlow

data class AddPasswordItemState(
    val name: String = "",
    val username: String = "",
    val password: String = "",
    val website: String = "",
    val notes: String = "",
    val category: CategoryModel? = null,
    val categoryItems: StateFlow<List<CategoryModel>>? = null,
    val showPassword: Boolean = false,
    val isCategoryDropdownVisible: Boolean = false,
    val isUnsavedChangesDialogVisible: Boolean = false,
    val isAlreadyAutoFocused: Boolean = false,
    val hasUserEnteredDetails: Boolean = false
)
