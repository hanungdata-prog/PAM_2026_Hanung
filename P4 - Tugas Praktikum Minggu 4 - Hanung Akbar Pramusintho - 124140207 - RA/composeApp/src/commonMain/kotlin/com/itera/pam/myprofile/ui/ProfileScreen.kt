package com.itera.pam.myprofile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itera.pam.myprofile.ui.components.InfoCard
import com.itera.pam.myprofile.ui.components.InfoItem
import com.itera.pam.myprofile.ui.components.ProfileHeader
import com.itera.pam.myprofile.viewmodel.ProfileUiState

@Composable
fun ProfileScreen(
    uiState: ProfileUiState,
    onEditClick: () -> Unit,
    onDarkModeChange: (Boolean) -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                ProfileHeader(
                    name = uiState.profile.name,
                    nim = uiState.profile.nim,
                    kelas = uiState.profile.kelas
                )
            }

            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                InfoCard(title = "Pengaturan") {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Dark Mode", fontSize = 15.sp)
                        Switch(
                            checked = uiState.isDarkMode,
                            onCheckedChange = onDarkModeChange
                        )
                    }
                }

                InfoCard(title = "Bio") {
                    Text(text = uiState.profile.bio, fontSize = 15.sp, lineHeight = 22.sp)
                }

                InfoCard(title = "Data Diri") {
                    Column {
                        InfoItem(
                            icon = Icons.Filled.Phone,
                            label = "Nomor HP",
                            value = uiState.profile.phone
                        )
                        InfoItem(
                            icon = Icons.Filled.LocationOn,
                            label = "Lokasi",
                            value = uiState.profile.location
                        )
                        InfoItem(
                            icon = Icons.Filled.Email,
                            label = "Email",
                            value = uiState.profile.email
                        )
                    }
                }

                Button(
                    onClick = onEditClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Edit Profile")
                }
            }
        }
    }
}
