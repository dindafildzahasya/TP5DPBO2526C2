# Data Anggota Perpustakaan


## Janji 


## Fitur

- Menampilkan data anggota dari database MySQL.
- Menambahkan anggota baru.
- Mengubah data anggota yang dipilih.
- Menghapus anggota dengan konfirmasi.
- Memvalidasi input wajib agar tidak kosong.
- Memeriksa ID duplikat saat menambahkan data.
- Menyimpan jumlah buku yang dipinjam dengan nilai 0–20.


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

