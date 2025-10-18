package com.example.passwordvault.data.mappers

import com.example.passwordvault.data.local.entity.PasswordItemEntity
import com.example.passwordvault.data.local.entity.PasswordWithCategoryEntity
import com.example.passwordvault.domain.model.PasswordWithCategoryModel

fun PasswordWithCategoryEntity.toModel(): PasswordWithCategoryModel {
    return PasswordWithCategoryModel(
        id = passwordItem.id,
        name = passwordItem.name,
        username = passwordItem.username,
        password = passwordItem.password,
        notes = passwordItem.notes,
        categoryId = categoryEntity?.id,
        categoryName = categoryEntity?.name,
        categoryColor = categoryEntity?.color,
        website = passwordItem.website,
        isAddedToWatch = passwordItem.isAddedToWatch,
        createdAt = passwordItem.createdAt
    )
}

fun PasswordWithCategoryModel.toPasswordItemEntity(): PasswordItemEntity {
    return if (id != null && createdAt != null) {
        PasswordItemEntity(
            id = id,
            name = name,
            username = username,
            password = password,
            notes = notes,
            categoryId = categoryId,
            website = website,
            isAddedToWatch = isAddedToWatch,
            createdAt = createdAt
        )
    } else {
        PasswordItemEntity(
            name = name,
            username = username,
            notes = notes,
            password = password,
            website = website,
            isAddedToWatch = isAddedToWatch,
            categoryId = categoryId
        )
    }
}
