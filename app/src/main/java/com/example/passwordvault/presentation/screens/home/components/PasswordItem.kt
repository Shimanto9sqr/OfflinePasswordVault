package com.example.passwordvault.presentation.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.passwordvault.domain.model.PasswordItemModel

@Composable
fun PasswordItem(item: PasswordItemModel, onClick: () -> Unit) {
    ListItem(
        headlineContent = { Text(item.name, maxLines = 1, overflow = TextOverflow.Ellipsis) },
        supportingContent = { Text(item.username, maxLines = 1, overflow = TextOverflow.Ellipsis) },
        modifier = Modifier.clickable(onClick = onClick)
    )
}

@Preview
@Composable
private fun PasswordItemPreview() {
    val item = PasswordItemModel(
        id = 1,
        name = "Google",
        username = "test@mail.com",
        password = "",
        notes = "",
        website = "",
        isAddedToWatch = false,
        categoryId = null,
        createdAt = 1
    )

    PasswordItem(item = item, onClick = {})
}
