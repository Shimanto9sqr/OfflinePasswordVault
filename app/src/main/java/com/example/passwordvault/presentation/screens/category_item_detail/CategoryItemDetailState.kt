package com.example.passwordvault.presentation.screens.category_item_detail

import com.example.passwordvault.domain.model.CategoryModel

data class CategoryItemDetailState(
    val categoryModel: CategoryModel? = null,
    val isChanged: Boolean = false,
    val isUnsavedChangesDialogVisible: Boolean = false,
    val isDeleteDialogVisible: Boolean = false
)
