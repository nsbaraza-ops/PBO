# PBO — Pemrograman Berorientasi Objek (Java)

Repository ini berisi kumpulan praktikum dan proyek mata kuliah **Pemrograman Berorientasi Objek (PBO)** menggunakan **Java**, mulai dari konsep dasar *class & object* hingga pengembangan aplikasi desktop GUI berbasis **Java Swing** yang terhubung dengan database **MySQL**.

## Daftar Materi & Struktur Direktori

| Direktori | Topik / Konsep OOP | File Utama |
| --- | --- | --- |
| `Tugas Praktik latihan 2/` | Pengenalan Class & Object | `TV.Java`, `TestTV.java` |
| `Tugas_pertemuan_5/` | Java Collections (`List`, dll.) | `LatihanCollection1.java` – `LatihanCollection3.java` |
| `Tugas_Pertemuan_8/` | Method Overloading & Polymorphism | `Sum.java`, `OverloadMain.java`, `DemoMain.java`, `polymorphism/` |
| `Tugas_Abstrak/` | Abstract Class & Interface | `BangunDatar.java`, `Kendaraan.java`, `Resizeable.java`, dll. |
| `Pertemuan_13/AplikasiPenilaianMhs/` | Aplikasi Desktop GUI (Java Swing + JDBC MySQL) | `FormNilaiMhs.java`, `Mhs.java`, `DBConnection.java` |

## Highlight Proyek: Aplikasi Penilaian Mahasiswa

Berada di `Pertemuan_13/AplikasiPenilaianMhs/`, aplikasi desktop ini menerapkan pemisahan layer sederhana:

- `model/Mhs.java` — Representasi model data mahasiswa.
- `database/DBConnection.java` — Koneksi JDBC ke database MySQL (`jdbc:mysql://localhost/pbo`).
- `gui/FormNilaiMhs.java` — Antarmuka Java Swing (`JFrame`, `JTable`) untuk penginputan dan pengelolaan nilai mahasiswa (NIM, Nama, UTS, UAS, Tugas).

## Cara Menjalankan

### 1. Latihan Konsep OOP (CLI)
Masuk ke direktori materi yang diinginkan, lalu compile dan jalankan file `.java` yang memiliki method `main`:

```bash
javac NamaFileMain.java
java NamaFileMain
```

### 2. Aplikasi Penilaian Mahasiswa (GUI)
1. Pastikan **MySQL** (misalnya melalui XAMPP) aktif dan tersedia database bernama `pbo`.
2. Buka folder `Pertemuan_13/AplikasiPenilaianMhs` menggunakan **NetBeans** (atau IDE Java lainnya) serta pastikan driver **MySQL Connector/J** sudah terpasang di library proyek.
3. Jalankan kelas utama `gui.FormNilaiMhs`.

## Lisensi

Repository ini dirilis di bawah [MIT License](LICENSE).
