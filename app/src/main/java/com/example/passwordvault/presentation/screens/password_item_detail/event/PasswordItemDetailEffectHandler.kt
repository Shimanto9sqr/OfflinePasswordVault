package com.example.passwordvault.presentation.screens.password_item_detail.event

import android.content.Context
import androidx.navigation.NavController
import com.google.android.gms.wearable.PutDataMapRequest
import com.google.android.gms.wearable.Wearable
import com.example.passwordvault.R
import com.example.passwordvault.core.copyToClipboard
import com.example.passwordvault.core.launchUrl
import com.example.passwordvault.domain.mappers.toPasswordItemDto
import com.example.passwordvault.domain.model.PasswordWithCategoryModel
import com.example.passwordvault.presentation.navigation.Routes
import com.example.passwordvault.core.showToast
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class PasswordItemDetailEffectHandler(
    private val context: Context,
    private val navController: NavController,
    private val onEvent: (PasswordItemDetailUiEvent) -> Unit
) {

    private val dataClient = Wearable.getDataClient(context)

    fun onToggleAddedToWatch(passwordItem: PasswordWithCategoryModel?) {
        val path = if (passwordItem?.isAddedToWatch != true) {
            "/upsert-password"
        } else {
            "/delete-password"
        }

        val putDataRequest = PutDataMapRequest.create(path).run {
            dataMap.putString("KEY-PASSWORD", Json.encodeToString(passwordItem?.toPasswordItemDto()))
            setUrgent()
            asPutDataRequest()
        }

        dataClient.putDataItem(putDataRequest).addOnSuccessListener {
            context.showToast(
                if (passwordItem?.isAddedToWatch != true) {
                    context.getString(R.string.toast_added_to_watch)
                } else {
                    context.getString(R.string.toast_removed_from_watch)
                }
            )

            onEvent(PasswordItemDetailUiEvent.ToggleAddToWatch)
        }
    }

    fun onDeleteItem(passwordItem: PasswordWithCategoryModel?) {
        onEvent(PasswordItemDetailUiEvent.ToggleDeleteDialogVisibility)

        if (passwordItem?.isAddedToWatch != true) {
            onEvent(PasswordItemDetailUiEvent.DeleteItem)
            navController.navigateUp()
            return
        }

        val putDataRequest = PutDataMapRequest.create("/delete-password").run {
            dataMap.putString("KEY-PASSWORD", Json.encodeToString(passwordItem.toPasswordItemDto()))
            setUrgent()
            asPutDataRequest()
        }

        dataClient.putDataItem(putDataRequest).addOnCompleteListener {
            onEvent(PasswordItemDetailUiEvent.DeleteItem)
            navController.navigateUp()
        }
    }

    fun onCopy(text: String?) {
        copyToClipboard(context, text)
    }

    fun onLaunchUrl(url: String) {
        launchUrl(context, url)
    }

    fun onNavigateToEditPassword(id: Int) {
        navController.navigate(Routes.EditPasswordItem(id))
    }

    fun onNavigateUp() {
        navController.navigateUp()
    }
}
