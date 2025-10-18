package com.example.passwordvault.domain.mappers

import com.example.passwordvault.domain.model.CategoryModel
import com.example.passwordvault.domain.model.PasswordWithCategoryModel
import com.example.passwordvault.data.dto.PasswordItemDto

fun PasswordWithCategoryModel.toPasswordItemDto(): PasswordItemDto {
    return PasswordItemDto(
        id = id ?: 0,
        name = name,
        username = username,
        password = password,
        notes = notes,
        createdAt = createdAt ?: 0
    )
}

fun PasswordWithCategoryModel.toCategoryModel(): CategoryModel? {
    return if (categoryId != null) {
        CategoryModel(
            id = categoryId,
            name = categoryName ?: "",
            color = categoryColor ?: ""
        )
    } else {
        null
    }
}