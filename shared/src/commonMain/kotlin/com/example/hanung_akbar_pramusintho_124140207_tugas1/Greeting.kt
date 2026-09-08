package com.example.hanung_akbar_pramusintho_124140207_tugas1

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return sayHello(platform.name)
    }
}