package com.example.passwordvault.presentation.screens.edit_password_item.event

import android.content.Context
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.navigation.NavController
import com.google.android.gms.wearable.PutDataMapRequest
import com.google.android.gms.wearable.Wearable
import com.example.passwordvault.domain.mappers.toPasswordItemDto
import com.example.passwordvault.domain.model.PasswordWithCategoryModel
import com.example.passwordvault.presentation.navigation.Routes
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class EditPasswordItemEffectHandler(
    context: Context,
    private val navController: NavController,
    private val keyboardController: SoftwareKeyboardController?
) {

    private val dataClient = Wearable.getDataClient(context)

    fun onEditComplete(newPasswordItemModel: PasswordWithCategoryModel?) {
        keyboardController?.hide()

        if (newPasswordItemModel?.isAddedToWatch == false) {
            navController.navigateUp()
            return
        }

        val putDataRequest = PutDataMapRequest.create("/upsert-password").run {
            dataMap.putString("KEY-PASSWORD", Json.encodeToString(newPasswordItemModel?.toPasswordItemDto()))
            setUrgent()
            asPutDataRequest()
        }

        dataClient.putDataItem(putDataRequest).addOnCompleteListener {
            navController.navigateUp()
        }
    }

    fun onNavigateToAddCategory() {
        navController.navigate(Routes.AddCategoryItem)
    }

    fun onNavigateUp() {
        navController.navigateUp()
    }
}
