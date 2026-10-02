package com.itera.pam.myprofile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.itera.pam.myprofile.components.InfoItem
import com.itera.pam.myprofile.components.ProfileCard
import com.itera.pam.myprofile.components.ProfileHeader

@Composable
fun App() {
    MaterialTheme {
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
                        name = "Hanung Akbar Pramusintho",
                        nim = "124140207",
                        kelas = "RA"
                    )
                }

                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    ProfileCard(title = "Data Diri") {
                        Column {
                            InfoItem(
                                icon = Icons.Filled.Phone,
                                label = "Nomor HP",
                                value = "085256910207"
                            )
                            InfoItem(
                                icon = Icons.Filled.LocationOn,
                                label = "Lokasi",
                                value = "Bandar Lampung"
                            )
                            InfoItem(
                                icon = Icons.Filled.Email,
                                label = "Email",
                                value = "hanungpramusintho@gmail.com"
                            )
                        }
                    }
                }
            }
        }
    }
}
