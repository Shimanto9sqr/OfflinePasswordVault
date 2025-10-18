package com.example.passwordvault.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import androidx.room.Room
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.example.passwordvault.data.local.dao.CategoryDao
import com.example.passwordvault.data.local.DATABASE_NAME
import com.example.passwordvault.data.local.MIGRATION_1_2
import com.example.passwordvault.data.local.dao.PasswordDao
import com.example.passwordvault.data.local.PasswordDatabase
import com.example.passwordvault.data.models.UserSettings
import com.example.passwordvault.data.repository.CategoryRepositoryImpl
import com.example.passwordvault.data.repository.DatabaseBackupManagerImpl
import com.example.passwordvault.data.repository.PassphraseRepositoryImpl
import com.example.passwordvault.data.repository.PasswordItemRepositoryImpl
import com.example.passwordvault.data.repository.UserPreferencesRepositoryImpl
import com.example.passwordvault.domain.repository.CategoryRepository
import com.example.passwordvault.domain.repository.DatabaseBackupManager
import com.example.passwordvault.domain.repository.PassphraseRepository
import com.example.passwordvault.domain.repository.PasswordItemRepository
import com.example.passwordvault.domain.repository.UserPreferencesRepository
import com.example.passwordvault.core.DataStoreEncryptionSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import net.zetetic.database.sqlcipher.SupportOpenHelperFactory
import javax.inject.Singleton

private const val USER_PREFERENCES = "user_preferences.json"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUserPreferencesRepository(
        dataStore: DataStore<UserSettings>
    ): UserPreferencesRepository {
        return UserPreferencesRepositoryImpl(
            dataStore = dataStore
        )
    }

    @Provides
    @Singleton
    fun providePasswordItemRepository(
        passwordDao: PasswordDao
    ): PasswordItemRepository {
        return PasswordItemRepositoryImpl(
            passwordDao = passwordDao
        )
    }

    @Provides
    @Singleton
    fun provideCategoryRepository(
        passwordDao: PasswordDao,
        categoryDao: CategoryDao
    ): CategoryRepository {
        return CategoryRepositoryImpl(
            passwordDao = passwordDao,
            categoryDao = categoryDao
        )
    }

    @Provides
    @Singleton
    fun providePassphraseRepository(
        passwordDao: PasswordDao,
        dataStore: DataStore<UserSettings>
    ): PassphraseRepository {
        return PassphraseRepositoryImpl(
            passwordDao = passwordDao,
            dataStore = dataStore
        )
    }

    @Provides
    @Singleton
    fun provideDatabaseManagerRepository(
        @ApplicationContext appContext: Context,
        passwordDao: PasswordDao,
        passphraseRepository: PassphraseRepository
    ): DatabaseBackupManager {
        return DatabaseBackupManagerImpl(
            appContext = appContext,
            passwordDao = passwordDao,
            passphraseRepository = passphraseRepository
        )
    }

    @Singleton
    @Provides
    fun providePreferencesDataStore(
        @ApplicationContext appContext: Context
    ): DataStore<UserSettings> {
        return DataStoreFactory.create(
            serializer = DataStoreEncryptionSerializer(
                context = appContext,
                serializer = UserSettings.serializer(),
                defaultValue = UserSettings()
            ),
            produceFile = { appContext.dataStoreFile(USER_PREFERENCES) },
            corruptionHandler = null,
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
        )
    }

    @Singleton
    @Provides
    fun provideSupportFactory(
        userPreferencesRepository: UserPreferencesRepository
    ): SupportOpenHelperFactory {
        val userPassphrase = userPreferencesRepository.getPassword()?.toByteArray(Charsets.UTF_8)
        return SupportOpenHelperFactory(userPassphrase)
    }

    @Singleton
    @Provides
    fun provideRoomDatabase(
        @ApplicationContext appContext: Context,
        supportFactory: SupportOpenHelperFactory
    ): PasswordDatabase {
        return Room.databaseBuilder(appContext, PasswordDatabase::class.java, DATABASE_NAME)
            .addMigrations(MIGRATION_1_2)
            .openHelperFactory(supportFactory)
            .fallbackToDestructiveMigration(true)
            .build()
    }

    @Singleton
    @Provides
    fun providePasswordDao(
        passwordDatabase: PasswordDatabase
    ): PasswordDao {
        return passwordDatabase.passwordDao()
    }

    @Singleton
    @Provides
    fun provideCategoryDao(
        passwordDatabase: PasswordDatabase
    ): CategoryDao {
        return passwordDatabase.categoryDao()
    }

    @Singleton
    @Provides
    fun provideAppUpdateManager(
        @ApplicationContext appContext: Context
    ): AppUpdateManager {
        return AppUpdateManagerFactory.create(appContext)
    }
}
