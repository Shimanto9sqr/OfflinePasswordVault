package com.example.passwordvault.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.VpnKey
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material.icons.sharp.VpnKey
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.passwordvault.R
import com.example.passwordvault.presentation.navigation.Routes
import com.example.passwordvault.presentation.navigation.navigateWithState

@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var bottomBarVisible by rememberSaveable { mutableStateOf(true) }
    val currentRoute = navBackStackEntry?.destination

    bottomBarVisible = when {
        (currentRoute?.hasRoute<Routes.Home>() == true) -> true
        (currentRoute?.hasRoute<Routes.PasswordGenerator>() == true) -> true
        (currentRoute?.hasRoute<Routes.Settings>() == true) -> true
        else -> false
    }

    if (bottomBarVisible) {
        NavigationBar {
            NavigationBarItem(
                selected = currentRoute?.hasRoute<Routes.Home>() == true,
                onClick = { navController.navigateWithState(Routes.Home) },
                label = { Text("Home") },
                icon = {
                    if (currentRoute?.hasRoute<Routes.Home>() == true) {
                        Icon(
                            imageVector = Icons.Sharp.Home,
                            contentDescription = "Home Screen"
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Outlined.Home,
                            contentDescription = "Home Screen"
                        )
                    }
                },
            )

            NavigationBarItem(
                selected = currentRoute?.hasRoute<Routes.PasswordGenerator>() == true,
                onClick = { navController.navigateWithState(Routes.PasswordGenerator) },
                label = { Text("Generator") },
                icon = {
                    if (currentRoute?.hasRoute<Routes.PasswordGenerator>() == true) {
                        Icon(
                            imageVector = Icons.Sharp.VpnKey,
                            contentDescription = "Password Generator"
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Outlined.VpnKey,
                            contentDescription = "Password Generator"
                        )
                    }

                }
            )

            NavigationBarItem(
                selected = currentRoute?.hasRoute<Routes.Settings>() == true,
                onClick = { navController.navigateWithState(Routes.Settings) },
                label = { Text("Settings") },
                icon = {
                    if (currentRoute?.hasRoute<Routes.Settings>() == true) {
                        Icon(
                            imageVector = Icons.Sharp.Settings,
                            contentDescription = "Settings Screen"
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Outlined.Settings,
                            contentDescription = "Settings Screen"
                        )
                    }
                }
            )
        }
    }
}
