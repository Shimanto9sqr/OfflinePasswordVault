package com.example.passwordvault.presentation.screens.manage_categories.event

import androidx.compose.foundation.lazy.LazyListState
import androidx.navigation.NavController
import com.example.passwordvault.presentation.navigation.Routes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ManageCategoriesEffectHandler(
    private val navController: NavController,
    private val scope: CoroutineScope
) {
    fun onScrollToTop(state: LazyListState) {
        scope.launch { state.animateScrollToItem(0) }
    }

    fun onNavigateToCategoryItem(id: Int) {
        navController.navigate(Routes.CategoryItemDetail(id))
    }

    fun onNavigateToAddCategory() {
        navController.navigate(Routes.AddCategoryItem)
    }

    fun onNavigateUp() {
        navController.navigateUp()
    }
}
