-- Database People Data - Data Anggota Perpustakaan

CREATE DATABASE db_anggotaPerpus;
USE db_anggotaPerpus;

CREATE TABLE IF NOT EXISTS person (
    id VARCHAR(10) PRIMARY KEY,
    nama VARCHAR(100) NOT NULL,
    thn_lahir INT NOT NULL,
    kategori ENUM('Mahasiswa', 'Dosen', 'Umum') NOT NULL,
    email VARCHAR(120) NOT NULL,
    jumlah_buku_dipinjam INT NOT NULL DEFAULT 0,
    CHECK (jumlah_buku_dipinjam >= 0 AND jumlah_buku_dipinjam <= 20)
);

INSERT INTO person (id, nama, thn_lahir, kategori, email, jumlah_buku_dipinjam)
VALUES
('P001', 'Budi Santoso', 2004, 'Mahasiswa', 'budi.santoso@example.com', 2),
('P002', 'Siti Rahmawati', 2003, 'Mahasiswa', 'siti.rahmawati@example.com', 11),
('P003', 'Ahmad Rizky', 2002, 'Mahasiswa', 'ahmad.rizky@example.com', 3),
('P004', 'Dewi Lestari', 1985, 'Dosen', 'dewi.lestari@example.com', 6),
('P005', 'Eko Prasetyo', 1998, 'Umum', 'eko.prasetyo@example.com', 10),
('P006', 'Fitriani', 2005, 'Mahasiswa', 'fitriani@example.com', 4),
('P007', 'Gita Permata', 1980, 'Dosen', 'gita.permata@example.com', 1),
('P008', 'Hendra Wijaya', 1990, 'Umum', 'hendra.wijaya@example.com', 7),
('P009', 'Indah Puspita', 2004, 'Mahasiswa', 'indah.puspita@example.com', 2),
('P010', 'Joko Saputra', 1978, 'Dosen', 'joko.saputra@example.com', 5),
('P011', 'Kartika Sari', 2003, 'Mahasiswa', 'kartika.sari@example.com', 1),
('P012', 'Lukman Hakim', 1988, 'Umum', 'lukman.hakim@example.com', 9),
('P013', 'Maya Anggraini', 2002, 'Mahasiswa', 'maya.anggraini@example.com', 4),
('P014', 'Nanda Firmansyah', 1975, 'Dosen', 'nanda.firmansyah@example.com', 2),
('P015', 'Putri Amelia', 2005, 'Mahasiswa', 'putri.amelia@example.com', 8);