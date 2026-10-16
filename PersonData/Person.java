public class Person {
    // ID unik anggota perpustakaan
    private String id;

    // Nama anggota perpustakaan
    private String nama;

    // Tahun lahir anggota
    private int tahunLahir;

    // Kategori anggota perpustakaan
    private String kategori;

    // Email anggota perpustakaan
    private String email;

    // Atribut bonus: jumlah buku yang sedang dipinjam
    private int jumlahBukuDipinjam;

    // Constructor untuk mengisi seluruh atribut anggota
    public Person(String id, String nama, int tahunLahir, String kategori, String email, int jumlahBukuDipinjam) {
        this.id = id;
        this.nama = nama;
        this.tahunLahir = tahunLahir;
        this.kategori = kategori;
        this.email = email;
        this.jumlahBukuDipinjam = jumlahBukuDipinjam;
    }

    // Getter untuk mengambil nilai setiap atribut
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getTahunLahir() {
        return tahunLahir;
    }

    public String getKategori() {
        return kategori;
    }

    public String getEmail() {
        return email;
    }

    public int getJumlahBukuDipinjam() {
        return jumlahBukuDipinjam;
    }

    // Setter untuk mengubah data anggota
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setTahunLahir(int tahunLahir) {
        this.tahunLahir = tahunLahir;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJumlahBukuDipinjam(int jumlahBukuDipinjam) {
        this.jumlahBukuDipinjam = jumlahBukuDipinjam;
    }
}