package com.example.passwordvault.presentation.screens.home

import com.example.passwordvault.domain.model.CategoryModel
import com.example.passwordvault.domain.model.FilterBy
import com.example.passwordvault.domain.model.PasswordItemModel
import com.example.passwordvault.domain.model.SortBy
import kotlinx.coroutines.flow.StateFlow

data class HomeState(
    val items: StateFlow<List<PasswordItemModel>>? = null,
    val categoryItems: StateFlow<List<CategoryModel>>? = null,
    val isLoading: Boolean = true,
    val sortBy: SortBy = SortBy.ALPHABET_ASCENDING,
    val filterBy: FilterBy = FilterBy.All,
    val filteredItems: StateFlow<List<PasswordItemModel>>? = null,
    val searchQuery: String = "",
    val isSearching: Boolean = false,
)
