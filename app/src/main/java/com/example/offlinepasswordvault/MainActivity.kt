package com.example.offlinepasswordvault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.offlinepasswordvault.ui.PinEntryScreen
import com.example.offlinepasswordvault.ui.theme.OfflinePasswordVaultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // optional, makes UI edge-to-edge

        setContent {
            OfflinePasswordVaultTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    // PIN Entry Screen
                    PinEntryScreen(
                        onPinCorrect = {
                            // TODO: Navigate to VaultScreen after PIN is correct
                            // For now, you can show a log or Toast to test
                        }
                    )
                }
            }
        }
    }
}
