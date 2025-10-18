package com.example.passwordvault.presentation.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.SortByAlpha
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.passwordvault.R
import com.example.passwordvault.domain.model.SortBy
import com.example.passwordvault.presentation.theme.pagePadding
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SortModalSheet(
    sheetState: SheetState,
    currentSortBy: SortBy,
    onValueChoose: (SortBy) -> Unit
) {
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = { scope.launch { sheetState.hide() } },
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        Text(
            text = "Sort By",
            modifier = Modifier.padding(pagePadding),
            style = MaterialTheme.typography.titleLarge
        )

        ListItem(
            leadingContent = {
                Icon(
                    imageVector = Icons.Outlined.SortByAlpha,
                    contentDescription = "Sort by Ascending Alphabet"
                )
            },
            headlineContent = {
                Text("A to Z")
            },
            trailingContent = {
                RadioButton(
                    selected = currentSortBy == SortBy.ALPHABET_ASCENDING,
                    onClick = { onValueChoose(SortBy.ALPHABET_ASCENDING) }
                )
            },
            modifier = Modifier.clickable { onValueChoose(SortBy.ALPHABET_ASCENDING) }
        )

        ListItem(
            leadingContent = {
                Icon(
                    imageVector = Icons.Outlined.SortByAlpha,
                    contentDescription = "Sort by Descending Alphabet"
                )
            },
            headlineContent = {
                Text("Z to A")
            },
            trailingContent = {
                RadioButton(
                    selected = currentSortBy == SortBy.ALPHABET_DESCENDING,
                    onClick = { onValueChoose(SortBy.ALPHABET_DESCENDING) }
                )
            },
            modifier = Modifier.clickable { onValueChoose(SortBy.ALPHABET_DESCENDING) }
        )

        ListItem(
            leadingContent = {
                Icon(
                    imageVector = Icons.Outlined.AccessTime,
                    contentDescription = "Sort by New"
                )
            },
            headlineContent = {
                Text("New to Old")
            },
            trailingContent = {
                RadioButton(
                    selected = currentSortBy == SortBy.NEWEST,
                    onClick = { onValueChoose(SortBy.NEWEST) }
                )
            },
            modifier = Modifier.clickable { onValueChoose(SortBy.NEWEST) }
        )

        ListItem(
            leadingContent = {
                Icon(
                    imageVector = Icons.Outlined.AccessTime,
                    contentDescription = "Sort by Old"
                )
            },
            headlineContent = {
                Text("Old to New")
            },
            trailingContent = {
                RadioButton(
                    selected = currentSortBy == SortBy.OLDEST,
                    onClick = { onValueChoose(SortBy.OLDEST) }
                )
            },
            modifier = Modifier.clickable { onValueChoose(SortBy.OLDEST) }
        )

        Spacer(modifier = Modifier.height(48.dp))
    }
}
