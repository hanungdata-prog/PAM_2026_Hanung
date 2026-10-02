package com.itera.pam.myprofile.viewmodel

import androidx.lifecycle.ViewModel
import com.itera.pam.myprofile.data.ProfileRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel : ViewModel() {

    private val repository = ProfileRepository()

    private val _uiState = MutableStateFlow(
        ProfileUiState(profile = repository.getProfile())
    )
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    fun startEdit() {
        _uiState.update { state ->
            state.copy(
                isEditing = true,
                editName = state.profile.name,
                editBio = state.profile.bio
            )
        }
    }

    fun cancelEdit() {
        _uiState.update { state -> state.copy(isEditing = false) }
    }

    fun onNameChange(value: String) {
        _uiState.update { state -> state.copy(editName = value) }
    }

    fun onBioChange(value: String) {
        _uiState.update { state -> state.copy(editBio = value) }
    }

    fun saveProfile() {
        _uiState.update { state ->
            val namaBaru = state.editName.trim().ifEmpty { state.profile.name }
            state.copy(
                profile = state.profile.copy(
                    name = namaBaru,
                    bio = state.editBio.trim()
                ),
                isEditing = false
            )
        }
    }

    fun setDarkMode(enabled: Boolean) {
        _uiState.update { state -> state.copy(isDarkMode = enabled) }
    }
}
