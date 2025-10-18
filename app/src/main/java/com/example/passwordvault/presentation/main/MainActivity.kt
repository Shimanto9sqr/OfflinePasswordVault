package com.example.passwordvault.presentation.main

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.rememberNavController
import com.example.passwordvault.constants.DEFAULT_APP_AUTO_LOCK_DELAY
import com.example.passwordvault.presentation.navigation.Router
import com.example.passwordvault.presentation.screens.password_lock.PasswordLockViewModel
import com.example.passwordvault.presentation.theme.PasswordManagerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    private val passwordLockViewModel: PasswordLockViewModel by viewModels()
    private val mainViewModel: MainViewModel by viewModels()
    private var autoLockStartTimeMillis: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        enableEdgeToEdge()

        splashScreen.setKeepOnScreenCondition {
            passwordLockViewModel.state.hasPasswordSet == null &&
                    mainViewModel.useDynamicColors == null
        }

        setContent {
            PasswordManagerTheme(dynamicColor = mainViewModel.useDynamicColors == true) {
                val navController = rememberNavController()
                Router(navController, passwordLockViewModel)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        checkForAutoLock()
    }

    override fun onPause() {
        super.onPause()
        saveCurrentTimeMillis()
    }

    private fun saveCurrentTimeMillis() {
        autoLockStartTimeMillis = System.currentTimeMillis()
    }

    private fun checkForAutoLock() {
        val millisElapsedSinceOnPause = System.currentTimeMillis() - autoLockStartTimeMillis
        val delay = mainViewModel.autoLockDelayMs ?: DEFAULT_APP_AUTO_LOCK_DELAY
        if (millisElapsedSinceOnPause >= delay) { passwordLockViewModel.setUnlocked(false) }
    }
}
