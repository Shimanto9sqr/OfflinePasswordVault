package com.example.passwordvault

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PasswordVault : Application() {

    companion object {
        const val SQL_CIPHER_NATIVE_LIB = "sqlcipher"
    }

    override fun onCreate() {
        super.onCreate()
        System.loadLibrary(SQL_CIPHER_NATIVE_LIB)
    }
}
