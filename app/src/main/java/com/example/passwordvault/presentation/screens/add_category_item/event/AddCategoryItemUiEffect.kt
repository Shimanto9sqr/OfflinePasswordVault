package com.example.passwordvault.presentation.screens.add_category_item.event

import com.example.passwordvault.domain.model.CategoryModel

sealed class AddCategoryItemUiEffect {
    data class NavigateUp(val model: CategoryModel? = null) : AddCategoryItemUiEffect()
}
