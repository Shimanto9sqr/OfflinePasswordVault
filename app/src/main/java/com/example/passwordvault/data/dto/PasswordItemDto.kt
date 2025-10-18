package com.example.passwordvault.data.dto

import kotlinx.serialization.Serializable

/**
 * Data transfer object for password items between Mobile and Wear OS
 */
@Serializable
data class PasswordItemDto(
    val id: Int = 0,
    val name: String,
    val username: String,
    val password: String,
    val notes: String,
    val createdAt: Long = System.currentTimeMillis()
)