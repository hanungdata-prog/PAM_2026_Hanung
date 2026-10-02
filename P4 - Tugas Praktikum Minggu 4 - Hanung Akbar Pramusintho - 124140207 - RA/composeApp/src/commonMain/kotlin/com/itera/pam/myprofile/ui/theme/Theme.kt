package com.itera.pam.myprofile.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val skemaTerang = lightColorScheme()
private val skemaGelap = darkColorScheme()

@Composable
fun ProfileTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) skemaGelap else skemaTerang,
        content = content
    )
}
