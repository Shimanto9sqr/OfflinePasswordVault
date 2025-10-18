package com.example.passwordvault.presentation.screens.settings

import com.example.passwordvault.R
import com.example.passwordvault.presentation.components.OptionItem

object SettingsOptions {
    val values = listOf(
        OptionItem(R.string.label_auto_lock_30_seconds, 30_000L),
        OptionItem(R.string.label_auto_lock_1_minute, 60_000L),
        OptionItem(R.string.label_auto_lock_2_minutes, 120_000L),
        OptionItem(R.string.label_auto_lock_5_minutes, 300_000L)
    )
}
