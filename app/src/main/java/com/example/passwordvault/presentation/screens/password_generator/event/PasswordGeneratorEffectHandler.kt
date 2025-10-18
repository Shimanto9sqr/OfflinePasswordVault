package com.example.passwordvault.presentation.screens.password_generator.event

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.material3.SnackbarHostState
import com.example.passwordvault.core.copyToClipboard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class PasswordGeneratorEffectHandler(
    private val context: Context,
    private val scope: CoroutineScope,
    private val snackbarHostState: SnackbarHostState,
) {

    fun onCopyText(text: String) {
        copyToClipboard(context, text)
    }

    fun onShowSnackbarMessage(@StringRes message: Int) {
        scope.launch {
            snackbarHostState.showSnackbar(context.getString(message))
        }
    }
}
