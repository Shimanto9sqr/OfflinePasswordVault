package com.example.passwordvault.domain.repository

import com.example.passwordvault.domain.model.CategoryModel
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getAllCategories(): Flow<List<CategoryModel>>
    fun getCategoryItem(id: Int): Flow<CategoryModel?>
    suspend fun insertCategoryItem(item: CategoryModel): Long
    suspend fun deleteCategoryItem(item: CategoryModel)
}