package com.itera.pam.myprofile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.itera.pam.myprofile.ui.EditProfileScreen
import com.itera.pam.myprofile.ui.ProfileScreen
import com.itera.pam.myprofile.ui.theme.ProfileTheme
import com.itera.pam.myprofile.viewmodel.ProfileViewModel

@Composable
fun App(viewModel: ProfileViewModel = viewModel { ProfileViewModel() }) {
    val uiState by viewModel.uiState.collectAsState()

    ProfileTheme(darkTheme = uiState.isDarkMode) {
        if (uiState.isEditing) {
            EditProfileScreen(
                name = uiState.editName,
                bio = uiState.editBio,
                onNameChange = viewModel::onNameChange,
                onBioChange = viewModel::onBioChange,
                onSave = viewModel::saveProfile,
                onCancel = viewModel::cancelEdit
            )
        } else {
            ProfileScreen(
                uiState = uiState,
                onEditClick = viewModel::startEdit,
                onDarkModeChange = viewModel::setDarkMode
            )
        }
    }
}
