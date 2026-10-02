package com.itera.pam.newsfeed.model

enum class Category(val label: String) {
    TEKNOLOGI("Teknologi"),
    OLAHRAGA("Olahraga"),
    EKONOMI("Ekonomi"),
    HIBURAN("Hiburan")
}

data class News(
    val id: Int,
    val title: String,
    val category: Category,
    val summary: String,
    val body: String
)
