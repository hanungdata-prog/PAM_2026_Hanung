package com.itera.pam.newsfeed

import com.itera.pam.newsfeed.data.NewsRepository
import com.itera.pam.newsfeed.data.ReadCounter
import com.itera.pam.newsfeed.model.Category
import com.itera.pam.newsfeed.model.News
import com.itera.pam.newsfeed.ui.toDisplayText
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private const val JUMLAH_BERITA = 4

fun main() = runBlocking {
    val repository = NewsRepository()
    val readCounter = ReadCounter()
    val kategoriPilihan = Category.TEKNOLOGI

    println("=== News Feed Simulator ===")
    println("Kategori yang ditampilkan : ${kategoriPilihan.label}")
    println("Sumber berita             : stream baru setiap 2 detik")
    println()

    val pencatat = launch {
        readCounter.count.collect { jumlah ->
            println("                       >>> sudah dibaca: $jumlah")
        }
    }

    val beritaTampil = mutableListOf<News>()
    var nomor = 1

    repository.newsStream()
        .filter { berita -> berita.category == kategoriPilihan }
        .take(JUMLAH_BERITA)
        .collect { berita ->
            beritaTampil += berita
            println(berita.toDisplayText(nomor))
            nomor++
            readCounter.markAsRead()
        }

    delay(200)
    pencatat.cancel()

    println()
    println("Mengambil detail ${beritaTampil.size} berita secara paralel")

    val mulai = System.currentTimeMillis()
    val detail = coroutineScope {
        beritaTampil
            .map { berita -> async { repository.fetchDetail(berita) } }
            .awaitAll()
    }
    val durasi = System.currentTimeMillis() - mulai

    println("Selesai dalam $durasi ms, kalau diambil bergantian butuh sekitar ${beritaTampil.size * NewsRepository.DELAY_DETAIL_MS} ms")
    println()
    detail.forEach { baris -> println(baris) }
    println()
    println("Total berita sudah dibaca : ${readCounter.count.value}")
}
