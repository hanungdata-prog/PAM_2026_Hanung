package com.example.hanung_akbar_pramusintho_124140207_tugas1

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform