package com.itera.pam.newsfeed.ui

import com.itera.pam.newsfeed.model.News

fun News.toDisplayText(nomor: Int): String = buildString {
    appendLine("[$nomor] ${category.label}")
    appendLine("    Judul     : $title")
    appendLine("    Ringkasan : $summary")
}
