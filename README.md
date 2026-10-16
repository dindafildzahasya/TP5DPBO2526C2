# PeopleData — Data Anggota Perpustakaan

Aplikasi desktop berbasis Java Swing untuk mengelola data anggota perpustakaan menggunakan database MySQL. Aplikasi menyediakan operasi CRUD (*Create, Read, Update, Delete*) dan validasi input.

## Fitur

- Menampilkan data anggota dari database MySQL.
- Menambahkan anggota baru.
- Mengubah data anggota yang dipilih.
- Menghapus anggota dengan konfirmasi.
- Memvalidasi input wajib agar tidak kosong.
- Memeriksa ID duplikat saat menambahkan data.
- Menyimpan jumlah buku yang dipinjam dengan nilai 0–20.

## Teknologi

- Java dan Java Swing
- MySQL dan JDBC MySQL Connector/J
- XAMPP dan phpMyAdmin
- IntelliJ IDEA

## Struktur Folder

```text
PersonData/
├── PersonData/                 # Source code/project Java (sesuaikan dengan IDE)
│   ├── PeopleMenu.java
│   ├── PeopleMenu.form
│   ├── Person.java
│   ├── Database.java
│   └── lib/
│       └── mysql-connector-j-*.jar
├── Dokumentasi/
│   ├── tampilan-aplikasi.png
│   ├── tambah-data.gif
│   ├── validasi-input-kosong.png
│   ├── validasi-id-duplikat.png
│   ├── ubah-data.gif
│   ├── validasi-update-kosong.png
│   ├── konfirmasi-hapus.png
│   └── hapus-data.gif
├── db_people_anggota_perpustakaan_15_data.sql
└── README.md
```

Sesuaikan nama file dokumentasi dengan screenshot, GIF, atau video yang benar-benar kamu simpan. Sertakan semua source code dan file project yang diperlukan.

## Desain Program

Antarmuka terdiri dari formulir data anggota, pilihan kategori, spinner jumlah buku dipinjam, tombol operasi, dan tabel data anggota.

| Kolom | Keterangan |
|---|---|
| ID | Identitas unik anggota |
| Nama | Nama anggota perpustakaan |
| Tahun Lahir | Tahun kelahiran anggota |
| Kategori | Mahasiswa, Dosen, atau Umum |
| Email | Alamat email anggota |
| Jumlah Buku Dipinjam | Jumlah buku yang sedang dipinjam |

### Screenshot antarmuka

Simpan screenshot aplikasi pada folder `Dokumentasi` dengan nama `tampilan-aplikasi.png`.

![Tampilan aplikasi PeopleData](Dokumentasi/tampilan-aplikasi.png)

## Database

Aplikasi menggunakan database `db_people` dengan tabel `person`.

Tabel memiliki kolom `id`, `nama`, `thn_lahir`, `kategori`, `email`, dan `jumlah_buku_dipinjam`. Kategori anggota adalah `Mahasiswa`, `Dosen`, dan `Umum`. File SQL yang disertakan berisi struktur tabel dan 15 data contoh.

## Alur Program

1. Aplikasi membuat koneksi ke database MySQL melalui class `Database`.
2. Method `setTable()` mengambil data dari tabel `person` dan menampilkannya di JTable.
3. Pengguna mengisi formulir untuk menambahkan anggota.
4. Operasi Add memeriksa input wajib, format tahun lahir, dan ID duplikat sebelum menyimpan data.
5. Ketika baris tabel dipilih, data baris tersebut ditampilkan pada formulir.
6. Operasi Update menyimpan perubahan berdasarkan ID anggota.
7. Operasi Delete meminta konfirmasi sebelum menghapus data.
8. Setelah operasi berhasil, tabel dimuat ulang dan formulir dikosongkan.

## Dokumentasi Operasi CRUD dan Validasi

Lengkapi bagian ini dengan screenshot, GIF, atau video dari aplikasi yang benar-benar dijalankan. Dokumentasi harus menunjukkan semua operasi CRUD dan semua dialog/prompt error yang dibuat.

### 1. Read — Menampilkan Data

Tunjukkan data anggota yang berhasil dimuat dari database.

![Menampilkan data anggota](Dokumentasi/tampilan-aplikasi.png)

### 2. Create — Menambahkan Data

Tunjukkan pengisian formulir, penambahan anggota, dan data baru pada tabel.

![Menambahkan data anggota](Dokumentasi/tambah-data.gif)

### 3. Validasi Input Kosong

Kosongkan salah satu input wajib, lalu tekan Add. Sertakan screenshot dialog peringatan.

![Validasi input kosong](Dokumentasi/validasi-input-kosong.png)

### 4. Validasi ID Duplikat

Masukkan ID yang sudah ada, lalu tekan Add. Sertakan screenshot dialog error.

![Validasi ID duplikat](Dokumentasi/validasi-id-duplikat.png)

### 5. Update — Mengubah Data

Pilih anggota, ubah datanya, simpan perubahan, lalu tunjukkan hasilnya di tabel.

![Mengubah data anggota](Dokumentasi/ubah-data.gif)

### 6. Validasi Input Kosong saat Update

Pilih anggota, kosongkan salah satu input wajib, lalu tekan Update. Sertakan screenshot dialog peringatan.

![Validasi input kosong saat update](Dokumentasi/validasi-update-kosong.png)

### 7. Delete — Menghapus Data

Tunjukkan pemilihan anggota, dialog konfirmasi, dan tabel setelah data dihapus.

![Konfirmasi penghapusan](Dokumentasi/konfirmasi-hapus.png)

![Hasil penghapusan data](Dokumentasi/hapus-data.gif)

### 8. Dialog Error Lainnya

Jika aplikasi memiliki dialog error lain, misalnya tahun lahir bukan angka atau kegagalan database, sertakan screenshot setiap dialog di folder `Dokumentasi`.

## Cara Menjalankan Aplikasi

1. Instal JDK yang sesuai dengan project.
2. Jalankan MySQL melalui XAMPP jika menggunakan instalasi XAMPP.
3. Buka phpMyAdmin dan impor `db_people_anggota_perpustakaan_15_data.sql`.
4. Pastikan database `db_people` dan tabel `person` sudah tersedia.
5. Pastikan MySQL Connector/J sudah ditambahkan sebagai dependency/library project.
6. Periksa pengaturan koneksi di `Database.java`. Konfigurasi lokal project:

   ```java
   DriverManager.getConnection(
       "jdbc:mysql://localhost:3306/db_people",
       "root",
       ""
   );
   ```

   Sesuaikan username, password, dan alamat server jika konfigurasi MySQL kamu berbeda.
7. Buka project di IntelliJ IDEA.
8. Jalankan class `PeopleMenu`.

> Jika database sudah berisi data, backup terlebih dahulu sebelum mengimpor SQL. Data contoh dapat gagal dimasukkan jika ID yang sama sudah ada.

## Catatan

- Pastikan MySQL aktif sebelum menjalankan aplikasi.
- Pastikan Connector/J tersedia pada classpath project.
- Jangan mengunggah password database pribadi atau kredensial sensitif ke repositori publik.
- Ganti gambar contoh pada README dengan dokumentasi asli aplikasi kamu sebelum mengumpulkan tugas.
