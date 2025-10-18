package com.example.passwordvault.domain.repository

interface PassphraseRepository {
    suspend fun updatePassword(newPassword: String)
}