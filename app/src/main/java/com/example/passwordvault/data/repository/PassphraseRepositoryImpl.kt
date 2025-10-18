package com.example.passwordvault.data.repository

import androidx.datastore.core.DataStore
import com.example.passwordvault.data.local.dao.PasswordDao
import com.example.passwordvault.data.models.UserSettings
import com.example.passwordvault.domain.repository.PassphraseRepository
import kotlinx.coroutines.flow.first

/**
 * [PassphraseRepository] - used only to [updatePassword] in [dataStore] and [passwordDao]
 */
class PassphraseRepositoryImpl(
    private val passwordDao: PasswordDao,
    private val dataStore: DataStore<UserSettings>
) : PassphraseRepository {

    override suspend fun updatePassword(newPassword: String) {
        val oldPassword = dataStore.data.first().password
        dataStore.updateData { prevUserSettings -> prevUserSettings.copy(password = newPassword) }
        passwordDao.changePassword(oldPassword, newPassword)
    }
}
