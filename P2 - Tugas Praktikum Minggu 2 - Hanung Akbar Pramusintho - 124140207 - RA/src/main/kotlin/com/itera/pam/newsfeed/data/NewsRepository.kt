package com.itera.pam.newsfeed.data

import com.itera.pam.newsfeed.model.Category
import com.itera.pam.newsfeed.model.News
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepository {

    private val daftarBerita = listOf(
        News(
            id = 1,
            title = "Kotlin 2.1 Resmi Dirilis",
            category = Category.TEKNOLOGI,
            summary = "Compiler baru diklaim 15 persen lebih cepat.",
            body = "Rilis ini membawa perbaikan performa compiler dan dukungan bahasa yang lebih stabil untuk proyek multi platform."
        ),
        News(
            id = 2,
            title = "Liga Indonesia Pekan Ke 12",
            category = Category.OLAHRAGA,
            summary = "Papan atas klasemen makin ketat.",
            body = "Tiga tim teratas hanya terpaut dua poin setelah pekan ke 12 selesai."
        ),
        News(
            id = 3,
            title = "Compose Multiplatform 1.7",
            category = Category.TEKNOLOGI,
            summary = "Preview di Android Studio kini jalan.",
            body = "Semua resource multi platform sekarang dikemas ke aset Android sehingga preview composable bisa langsung dipakai."
        ),
        News(
            id = 4,
            title = "Nilai Tukar Menguat",
            category = Category.EKONOMI,
            summary = "Rupiah menguat tipis pagi ini.",
            body = "Penguatan didorong aliran modal masuk ke pasar obligasi dan ekspektasi pemangkasan suku bunga."
        ),
        News(
            id = 5,
            title = "StateFlow dan SharedFlow",
            category = Category.TEKNOLOGI,
            summary = "Kapan pakai yang mana.",
            body = "StateFlow cocok untuk menyimpan state terbaru, sementara SharedFlow lebih tepat untuk kejadian satu kali seperti notifikasi."
        ),
        News(
            id = 6,
            title = "Film Animasi Lokal Tembus Festival",
            category = Category.HIBURAN,
            summary = "Masuk seleksi resmi festival Asia.",
            body = "Studio animasi lokal berhasil masuk daftar seleksi dan akan tayang perdana bulan depan."
        ),
        News(
            id = 7,
            title = "Coroutines untuk Pemula",
            category = Category.TEKNOLOGI,
            summary = "Kenali suspend, launch, dan async.",
            body = "Suspend function bisa berhenti tanpa memblokir thread, sedangkan async dipakai ketika hasilnya masih dibutuhkan."
        ),
        News(
            id = 8,
            title = "Bursa Sesi Pagi Dibuka Hijau",
            category = Category.EKONOMI,
            summary = "Indeks naik 0,4 persen.",
            body = "Sektor perbankan dan energi memimpin penguatan pada sesi pembukaan."
        ),
        News(
            id = 9,
            title = "Turnamen Bulu Tangkis Nasional",
            category = Category.OLAHRAGA,
            summary = "Final digelar akhir pekan ini.",
            body = "Delapan pemain terbaik akan bertanding memperebutkan gelar juara nasional."
        )
    )

    fun newsStream(): Flow<News> = flow {
        var index = 0
        while (true) {
            emit(daftarBerita[index % daftarBerita.size])
            index++
            delay(DELAY_BERITA_MS)
        }
    }

    suspend fun fetchDetail(news: News): String {
        delay(DELAY_DETAIL_MS)
        return "- ${news.title}: ${news.body}"
    }

    companion object {
        const val DELAY_BERITA_MS = 2000L
        const val DELAY_DETAIL_MS = 800L
    }
}
