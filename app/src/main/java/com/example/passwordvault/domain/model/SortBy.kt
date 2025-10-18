package com.example.passwordvault.domain.model

import com.example.passwordvault.data.local.entity.PasswordItemEntity

enum class SortBy {
    ALPHABET_ASCENDING,
    ALPHABET_DESCENDING,
    NEWEST,
    OLDEST
}

fun SortBy.orderBy(): String {
    return when (this) {
        SortBy.ALPHABET_ASCENDING -> "name ASC"
        SortBy.ALPHABET_DESCENDING -> "name DESC"
        SortBy.NEWEST -> "created_at DESC"
        SortBy.OLDEST -> "created_at ASC"
    }
}
