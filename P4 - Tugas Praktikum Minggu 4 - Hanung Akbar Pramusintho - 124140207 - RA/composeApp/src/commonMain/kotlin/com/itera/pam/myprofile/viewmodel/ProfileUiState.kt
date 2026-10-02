package com.itera.pam.myprofile.viewmodel

import com.itera.pam.myprofile.data.Profile

data class ProfileUiState(
    val profile: Profile = Profile(
        name = "",
        nim = "",
        kelas = "",
        bio = "",
        email = "",
        phone = "",
        location = ""
    ),
    val editName: String = "",
    val editBio: String = "",
    val isEditing: Boolean = false,
    val isDarkMode: Boolean = false
)
