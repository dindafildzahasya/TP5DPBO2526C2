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

## Dokumentasi Operasi CRUD 


### 1. ID Duplikat


https://github.com/user-attachments/assets/fd62fea8-1956-4c22-8ff2-0227274868b4


### 2. Data Kosong


https://github.com/user-attachments/assets/eec6b7b5-76a7-4812-9d18-e99dcf9324f7


### 3. Tahun Lahir Bukan Angka


https://github.com/user-attachments/assets/bc2d83f3-a586-4644-8081-1d08cbff3f9b


### 4. Add


https://github.com/user-attachments/assets/cc687828-e7ac-46bc-8d11-3dd7c446ff68


### 5. Update


https://github.com/user-attachments/assets/95b7300e-4aaf-4d57-b89f-42c408c014e3


### 6. Delete


https://github.com/user-attachments/assets/c2a5634e-aa86-4957-b612-78826c6504bf

