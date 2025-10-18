package com.example.passwordvault.presentation.screens.change_password.event

import android.content.Context
import androidx.navigation.NavController
import com.example.passwordvault.R
import com.example.passwordvault.core.showToast

class ChangePasswordEffectHandler(
    private val context: Context,
    private val navController: NavController
) {

    fun onPasswordUpdated() {
        navController.navigateUp()
        context.showToast(context.getString(R.string.toast_password_changed_successfully))
    }

    fun onNavigateUp() {
        navController.navigateUp()
    }
}
