package com.example.passwordvault.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CategoryModel(
    val id: Int? = null,
    val name: String,
    val color: String,
    val createdAt: Long? = null
)
