package com.example.passwordvault.presentation.screens.android_watch


data class AndroidWatchState(
    val useAndroidWatch: Boolean? = null,
    val hasAndroidWatchPinSet: Boolean? = null,
    val pin: String = "",
    val showPin: Boolean = false,
    val showDisableAndroidWatchDialog: Boolean = false
)
