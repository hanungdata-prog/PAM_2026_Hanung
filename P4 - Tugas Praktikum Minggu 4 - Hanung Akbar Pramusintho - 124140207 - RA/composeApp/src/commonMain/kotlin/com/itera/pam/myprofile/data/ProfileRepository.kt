package com.itera.pam.myprofile.data

class ProfileRepository {

    fun getProfile(): Profile = Profile(
        name = "Hanung Akbar Pramusintho",
        nim = "124140207",
        kelas = "RA",
        bio = "Mahasiswa Teknik Informatika ITERA yang sedang belajar pengembangan aplikasi mobile dengan Kotlin dan Compose Multiplatform.",
        email = "hanungpramusintho@gmail.com",
        phone = "085256910207",
        location = "Bandar Lampung"
    )
}
