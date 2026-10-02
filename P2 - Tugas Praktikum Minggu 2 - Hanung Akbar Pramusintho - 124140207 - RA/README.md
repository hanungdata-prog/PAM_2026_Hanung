# Tugas Praktikum 2 PAM

**Nama:** Hanung Akbar Pramusintho
**NIM:** 124140207
**Kelas PAM :** RA

News Feed Simulator, proyek Kotlin untuk mensimulasikan aliran berita masuk. Proyek ini memakai Flow, StateFlow, dan Coroutines sesuai tugas praktikum 2.

## Fitur

1. Flow yang memunculkan berita baru setiap 2 detik
2. Filter berita berdasarkan kategori, pada contoh ini hanya kategori Teknologi yang dilewatkan
3. Transform data berita menjadi format tampilan yang siap dicetak ke konsol
4. StateFlow untuk menyimpan jumlah berita yang sudah dibaca, nilainya dicetak setiap kali berubah
5. Coroutines async untuk mengambil detail beberapa berita sekaligus secara paralel

## Hasil program

<img src="screenshot-output.png" width="430">

## Struktur folder

```
src
  main
    kotlin
      com.itera.pam.newsfeed
        Main.kt
        model   News.kt
        data    NewsRepository.kt, ReadCounter.kt
        ui      DisplayFormat.kt
```

## Cara menjalankan

Lewat terminal, jalankan perintah berikut di folder proyek:

```
gradlew.bat run
```

Atau buka folder ini di Android Studio, tunggu Gradle sync selesai, lalu jalankan file `Main.kt` dengan klik ikon run di sebelah `fun main`.

Program berjalan sekitar 13 detik karena berita baru muncul setiap 2 detik. Setelah 4 berita kategori Teknologi terkumpul, program langsung mengambil detail keempat berita itu secara paralel dan menampilkan total berita yang sudah dibaca.
