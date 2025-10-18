package com.example.passwordvault.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.passwordvault.R
import com.example.passwordvault.constants.colorList
import com.example.passwordvault.presentation.theme.PasswordManagerTheme

@Composable
fun BoxScope.CheckmarkCircle(
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = Icons.Outlined.Done,
        tint = Color.Green,
        contentDescription = "Selected color",
        modifier = modifier
            .size(16.dp)
            .align(Alignment.Center)
            .fillMaxWidth()
            .clip(CircleShape)
            .background(Color.White)
    )
}

@Preview
@Composable
private fun CheckmarkCirclePreview() {
    PasswordManagerTheme {
        Box {
            ColoredCircle(color = colorList[3]) {
                CheckmarkCircle()
            }
        }
    }
}
