package com.example.passwordvault.presentation.screens.edit_password_item

import com.example.passwordvault.domain.model.CategoryModel
import com.example.passwordvault.domain.model.PasswordWithCategoryModel
import kotlinx.coroutines.flow.StateFlow

data class EditPasswordItemState(
    val passwordItem: PasswordWithCategoryModel? = null,
    val category: CategoryModel? = null,
    val categoryItems: StateFlow<List<CategoryModel>>? = null,
    val isChanged: Boolean = false,
    val showPassword: Boolean = false,
    val isUnsavedChangesDialogVisible: Boolean = false,
    val isAlreadyAutoFocused: Boolean = false,
    val isCategoryDropdownVisible: Boolean = false
)
