# Data Anggota Perpustakaan


## Janji 
Saya Adinda Fildzah Hasya dengan NIM 2501218 mengerjakan Tugas Praktikum 5 pada Mata Kuliah Desain dan Pemrograman Berorientasi Objek (DPBO) untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin


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

### 1. ID Duplikat




### 2. Data Kosong



![Menambahkan data anggota](Dokumentasi/tambah-data.gif)

### 3. Tahun Lahir Bukan Angka



![Validasi input kosong](Dokumentasi/validasi-input-kosong.png)

### 4. Add


![Validasi ID duplikat](Dokumentasi/validasi-id-duplikat.png)

### 5. Update


![Mengubah data anggota](Dokumentasi/ubah-data.gif)

### 6. Delete



![Validasi input kosong saat update](Dokumentasi/validasi-update-kosong.png)

