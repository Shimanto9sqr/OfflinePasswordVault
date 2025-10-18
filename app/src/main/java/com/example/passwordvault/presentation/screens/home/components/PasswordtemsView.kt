package com.example.passwordvault.presentation.screens.home.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.jackappsdev.password_manager.R
import com.example.passwordvault.presentation.components.EmptyStateView
import com.example.passwordvault.presentation.screens.home.HomeState
import com.example.passwordvault.presentation.screens.home.event.HomeUiEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordItemsView(
    modifier: Modifier = Modifier,
    state: HomeState,
    lazyColumnState: LazyListState,
    onEvent: (HomeUiEvent) -> Unit
) {
    val filteredItems = state.filteredItems?.collectAsState()?.value
    val passwordItems = state.items?.collectAsState()?.value
    val items = filteredItems ?: passwordItems

    LazyColumn(
        state = lazyColumnState,
        modifier = modifier.fillMaxSize()
    ) {
        item {
            SearchBar(
                state = state,
                onEvent = onEvent,
            )
        }

        if (state.searchQuery.isNotEmpty() && filteredItems?.isEmpty() == true) {
            item {
                EmptyStateView(
                    icon = R.drawable.search,
                    title = R.string.text_no_passwords,
                )
            }
        }

        items?.let {
            items(it) { item ->
                PasswordItem(
                    item = item,
                    onClick = { onEvent(HomeUiEvent.NavigateToPasswordItem(item.id ?: 0)) }
                )
            }
        }
    }
}
