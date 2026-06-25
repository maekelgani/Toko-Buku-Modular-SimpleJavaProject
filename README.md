# Toko-Buku-Modular-SimpleJavaProject
Repositori ini memuat proyek implementasi **Sistem Manajemen Toko Buku Digital** menggunakan arsitektur Java Platform Module System (JPMS). Proyek ini dikembangkan sebagai pemenuhan tugas kelompok mahasiswa untuk mata kuliah **Pemrograman Berorientasi Objek (Kelas RD)**.

---

## 👥 Anggota TIM
1. **Fadjar Wicaksono** : [202333500755]
2. **Muhamad Faizal Ardiansyah** : [202333500728] - GitHub: [@mfzlrdi](https://github.com/mfzlrdi)
3. **Maekel Mahdi Firman Gani** : [202333500714]

---

## 📝 Instruksi dan Ketentuan Tugas

- **Pemisahan Modul Independen:** Kode program wajib dipecah ke dalam tiga modul terpisah untuk mengisolasi fungsi sistem.
- **Konfigurasi Deskriptor (JPMS):** Setiap modul dilengkapi dengan berkas `module-info.java` pada akar direktori (*root*) untuk mengelola dependensi dan ekspor *package* secara eksplisit.
- **Enkapsulasi Ketat (Larangan Keras):** Sistem didesain sedemikian rupa sehingga modul antar-muka (`app.ui`) dilarang keras untuk berinteraksi atau mengakses *package* internal milik modul data (`app.data`) secara langsung. Semua komunikasi dijembatani secara aman oleh modul logika (`app.logic`).

---

## 🏗️ Struktur Arsitektur Modul

1. **`app.data`**
   - Bertanggung jawab atas pengelolaan entitas, struktur data buku, dan penyimpanan (lokal/memori).
   - *Hanya diekspor ke modul logic.*

2. **`app.logic`**
   - Merupakan otak dari aplikasi. Berisi *business logic*, layanan transaksi, dan pengelolaan data. 
   - *Bertindak sebagai jembatan yang menghubungkan Data dan UI.*

3. **`app.ui`**
   - Menangani antarmuka pengguna (User Interface), baik berbasis Console maupun GUI.
   - *Secara ketat hanya berkomunikasi dengan modul logic tanpa mengetahui implementasi dasar dari modul data.*
