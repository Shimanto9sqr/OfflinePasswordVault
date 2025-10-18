package com.example.passwordvault.data.mappers

import com.example.passwordvault.data.local.entity.CategoryEntity
import com.example.passwordvault.domain.model.CategoryModel

fun CategoryEntity.toModel(): CategoryModel {
    return CategoryModel(
        id = id,
        name = name,
        color = color,
        createdAt = createdAt
    )
}

fun CategoryModel.toEntity(): CategoryEntity {
    return if (id != null && createdAt != null) {
        CategoryEntity(
            id = id,
            name = name,
            color = color,
            createdAt = createdAt
        )
    } else {
        CategoryEntity(
            name = name,
            color = color,
        )
    }
}
