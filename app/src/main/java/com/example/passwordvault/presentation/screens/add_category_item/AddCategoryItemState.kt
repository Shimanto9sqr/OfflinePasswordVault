package com.example.passwordvault.presentation.screens.add_category_item

import com.example.passwordvault.constants.colorList


data class AddCategoryItemState(
    val name: String = "",
    val color: String = colorList.first(),
    val isUnsavedChangesDialogVisible: Boolean = false
)
