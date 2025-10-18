package com.example.passwordvault.presentation.screens.manage_categories

import com.example.passwordvault.domain.model.CategoryModel
import kotlinx.coroutines.flow.StateFlow

data class ManageCategoriesState(
    val items: StateFlow<List<CategoryModel>>? = null,
    val isLoading: Boolean = true
)
