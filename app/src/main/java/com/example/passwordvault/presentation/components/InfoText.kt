package com.example.passwordvault.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.passwordvault.R
import com.example.passwordvault.presentation.theme.PasswordManagerTheme
import com.example.passwordvault.presentation.theme.pagePadding

@Composable
fun InfoText(
    modifier: Modifier = Modifier,
    text: String
) {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.Info,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(pagePadding))
        Text(text = text)
    }
}

@Preview
@Composable
fun InfoTextPreview() {
    PasswordManagerTheme {
        Surface {
            InfoText(
                modifier = Modifier.padding(pagePadding),
                text = "Please remember this password. You can not log into app except this"
            )
        }
    }
}
