package com.example.passwordvault.presentation.screens.android_watch

import androidx.annotation.StringRes

sealed interface AndroidWatchError {
    data class PinError(@StringRes val error: Int) : AndroidWatchError
}
