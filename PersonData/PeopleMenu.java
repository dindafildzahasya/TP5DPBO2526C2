import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleMenu {
    private JPanel mainPanel;
    private JTextField idField;
    private JTextField namaField;
    private JTextField tahunLahirField;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton cancelButton;
    private JComboBox<String> kategoriComboBox;
    private JTextField emailField;
    private JTable peopleTable;
    private JSpinner jumlahBukuDipinjamSpinner;
    // Objek untuk mengakses database MySQL
    private Database database;
    // Indeks baris yang dipilih pada Jtable dan untuk -1 berarti tidak ada pilihan
    private int selectedIndex = -1;

    public PeopleMenu() {
        // Menghubungkan program ke database
        database = new Database();

        // Menentukan kategori anggota perpustakaan
        kategoriComboBox.setModel(
                new DefaultComboBoxModel<>(new String[]{"???", "Mahasiswa", "Dosen", "Umum"})
        );

        // Mengatur jumlah buku minimum 0 dan maksimum 20
        jumlahBukuDipinjamSpinner.setModel(
                new SpinnerNumberModel(0, 0, 20, 1)
        );

        // Menyembunyikan tombol Delete saat aplikasi pertama dibuka
        deleteButton.setVisible(false);

        // Menyebunyikan tombol update
        updateButton.setVisible(false);

        // Mengambil data awal dari database
        setTable();

        // Menghubungkan tombol dengan method CRUD
        addButton.addActionListener(e -> {
            if (selectedIndex == -1) {
                insertData();
            } else {
                updateData();
            }
        });
        deleteButton.addActionListener(e -> deleteData());
        cancelButton.addActionListener(e -> clearForm());

        // MouseListener mendeteksi baris yang ditekan pengguna
        peopleTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                // Menyimpan indeks baris yang dipilih
                selectedIndex = peopleTable.getSelectedRow();

                if (selectedIndex != -1) {
                    // Mengisi formulir dengan data pada baris yang dipilih
                    selectData();
                    // Mengubah tombol Add menjadi Update dan menampilkan Delete
                    addButton.setText("Update");
                    deleteButton.setVisible(true);
                }
            }
        });
    }

    // Method untuk menampilkan data ArrayList ke dalam JTable
    public void setTable() {
        String[] columnNames = {
                "ID", "Nama", "Tahun Lahir", "Kategori", "Email", " Jumlah Buku Dipinjam"
        };

        // Membuat model tabel dengan nama kolom dan nol baris awal
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Query untuk mengambil semua anggota dari database
        String sql = "SELECT * FROM person";

        try {
            // Menjalankan query SELECT
            ResultSet resultSet = database.selectQuery(sql);

            while (resultSet.next()) {
                Object[] rowData = {
                        resultSet.getString("id"),
                        resultSet.getString("nama"),
                        resultSet.getInt("thn_lahir"),
                        resultSet.getString("kategori"),
                        resultSet.getString("email"),
                        resultSet.getInt("jumlah_buku_dipinjam")
                };
                model.addRow(rowData);
            }
            resultSet.close();
        } catch (SQLException e) {
            // Menampilkan pesan jika data gagal dibaca
            JOptionPane.showMessageDialog(
                    mainPanel, "Gagal mengambil data dari database: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        // Menampilkan model yang sudah berisi data pada JTable
        peopleTable.setModel(model);
    }

    // Method untuk menambahkan data baru
    public void insertData() {
        // Mengambil nilai dari form
        String id = idField.getText().trim();
        String nama = namaField.getText().trim();
        String tahunLahirText = tahunLahirField.getText().trim();
        String kategori = (String) kategoriComboBox.getSelectedItem();
        String email = emailField.getText().trim();
        int jumlahBuku = (Integer) jumlahBukuDipinjamSpinner.getValue();

        // Memeriksa input kosong
        if (id.isEmpty() || nama.isEmpty()
                || tahunLahirText.isEmpty() || email.isEmpty()
                || kategoriComboBox.getSelectedIndex() == 0) {

            JOptionPane.showMessageDialog(
                    mainPanel, "Semua data harus diisi!",
                    "Peringatan", JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        try {
            // Mengubah tahun lahir menjadi bilangan bulat
            int tahunLahir = Integer.parseInt(tahunLahirText);

            // Memeriksa apakah ID sudah ada di database
            String cekID = "SELECT id FROM person WHERE id = '" + id + "'";
            ResultSet resultSet = database.selectQuery(cekID);

            boolean idAda = resultSet.next();
            resultSet.close();

            // Membatalkan penambahan jika ID sudah ada
            if (idAda) {
                JOptionPane.showMessageDialog(
                        mainPanel, "ID anggota sudah digunakan!",
                        "Error", JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            // Membuat query INSERT untuk menyimpan anggota baru.
            String sql = "INSERT INTO person "
                    + "(id, nama, thn_lahir, kategori, email, jumlah_buku_dipinjam) "
                    + "VALUES ('" + id + "', '" + nama + "', "
                    + tahunLahir + ", '" + kategori + "', '"
                    + email + "', " + jumlahBuku + ")";

            // Menjalankan query penambahan data
            database.insertUpdateDeleteQuery(sql);

            // Memperbarui tabel dari database
            setTable();
            clearForm();

            JOptionPane.showMessageDialog(mainPanel, "Data anggota berhasil ditambahkan!");

        } catch (NumberFormatException e) {
            // Menangani tahun lahir yang bukan angka
            JOptionPane.showMessageDialog(
                    mainPanel, "Tahun lahir harus berupa angka!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            // Menangani kesalahan SQL saat memeriksa ID
            JOptionPane.showMessageDialog(mainPanel,
                    "Terjadi kesalahan database: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Mengosongkan input dan mengembalikan tombol ke kondisi awal
    public void clearForm() {
        idField.setText("");
        namaField.setText("");
        tahunLahirField.setText("");
        emailField.setText("");
        // Mengatur kembali kategori fan jumlah buku
        kategoriComboBox.setSelectedIndex(0);
        jumlahBukuDipinjamSpinner.setValue(0);
        // Mengizinkan ID diedit kembali untuk data baru
        idField.setEditable(true);
        // Mereset indeks dan pilihan baris tabel
        selectedIndex = -1;
        peopleTable.clearSelection();
        // Mengembalikan teks tombol Add dan menyembunyikan tombol lain.
        addButton.setText("Add");
        deleteButton.setVisible(false);
    }

    // Method untuk mengambil data dari baris tabel yang dipilih
    public void selectData() {
        if (selectedIndex != -1) {
            // Membaca ID dari kolom 0
            String curId = peopleTable.getModel()
                    .getValueAt(selectedIndex, 0).toString();
            // Membaca nama dari kolom 1
            String curNama = peopleTable.getModel()
                    .getValueAt(selectedIndex, 1).toString();
            // Membaca tahun lahir dari kolom 2
            String curTahun = peopleTable.getModel()
                    .getValueAt(selectedIndex, 2).toString();
            // Membaca kategori dari kolom 3
            String curKategori = peopleTable.getModel()
                    .getValueAt(selectedIndex, 3).toString();
            // Membaca email dari kolom 4
            String curEmail = peopleTable.getModel()
                    .getValueAt(selectedIndex, 4).toString();
            // Membaca jumlah buku dipinjam dari kolom 5
            int curJumlahBuku = Integer.parseInt(peopleTable.getModel()
                    .getValueAt(selectedIndex, 5).toString());

            idField.setText(curId);
            namaField.setText(curNama);
            tahunLahirField.setText(curTahun);
            kategoriComboBox.setSelectedItem(curKategori);
            emailField.setText(curEmail);
            jumlahBukuDipinjamSpinner.setValue(curJumlahBuku);

            idField.setEditable(false);
        }
    }

    // Method untuk memperbarui data karyawan yang dipilih
    public void updateData() {
        // Memastikan ada baris yang dipilih
        int row = peopleTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(mainPanel,
                    "Pilih data yang ingin diubah!",
                    "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Mengambil nilai terbaru dari formulir
        String id = idField.getText().trim();
        String nama = namaField.getText().trim();
        String tahunLahirText = tahunLahirField.getText().trim();
        String kategori = (String) kategoriComboBox.getSelectedItem();
        String email = emailField.getText().trim();
        int jumlahBuku = (Integer) jumlahBukuDipinjamSpinner.getValue();

        // Memastikan input wajib sudah lengkap
        if (id.isEmpty() || nama.isEmpty()
                || tahunLahirText.isEmpty() || email.isEmpty()
                || kategoriComboBox.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(mainPanel, "Semua data harus diisi!",
                    "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int tahunLahir = Integer.parseInt(tahunLahirText);
            // Query UPDATE mengganti data anggota dengan ID yang dipilih
            String sql = "UPDATE person SET "
                    + "nama = '" + nama + "', "
                    + "thn_lahir = " + tahunLahir + ", "
                    + "kategori = '" + kategori + "', "
                    + "email = '" + email + "', "
                    + "jumlah_buku_dipinjam = " + jumlahBuku
                    + " WHERE id = '" + id + "'";

            database.insertUpdateDeleteQuery(sql);

            // Memuat data terbaru dan mereset formulir
            setTable();
            clearForm();

            JOptionPane.showMessageDialog(mainPanel, "Data anggota berhasil diubah!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainPanel,
                    "Tahun lahir harus berupa angka!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method untuk menghapus anggota terpilih setelah pengguna memberi informasi
    public void deleteData() {
        int row = peopleTable.getSelectedRow();
        // Membatalkan proses jika belum ada baris yang dipilih
        if (row == -1) {
            JOptionPane.showMessageDialog(mainPanel,
                    "Pilih data yang ingin dihapus!",
                    "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Meminta konfirmasi sebelum menghapus data
        int konfirmasi = JOptionPane.showConfirmDialog(mainPanel,
                "Apakah Anda yakin ingin menghapus data ini?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION);

        // Lanjutkan jika penggunya memilih yes
        if (konfirmasi == JOptionPane.YES_OPTION) {
            String id = peopleTable.getValueAt(row, 0).toString();

            String sql = "DELETE FROM person WHERE id = '" + id + "'";

            try {
                database.insertUpdateDeleteQuery(sql);
                // Memuat ulang tabel dan mengosongkan formulir
                setTable();
                clearForm();
                // Menampilkan pesan keberhasilan
                JOptionPane.showMessageDialog(mainPanel, "Data anggota berhasil dihapus!");

            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(mainPanel,
                        "Gagal menghapus data: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Method untuk menjalankan aplikasi
    public static void main(String[] args) {

        // Membuat jendela aplikasi dengan judul People Data
        JFrame frame = new JFrame("People Data");

        // Membuat objek PeopleMenu dan menginisialisasi komponen form
        PeopleMenu peopleMenu = new PeopleMenu();

        // Memasukkan panel utama ke dalam jendela aplikasi
        frame.setContentPane(peopleMenu.mainPanel);

        // Menentukan agar aplikasi berhenti ketika jendela ditutup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menyesuaikan ukuran jendela dengan komponen di dalamnya
        frame.pack();

        // Menempatkan jendela di tengah layar
        frame.setLocationRelativeTo(null);

        // Menampilkan jendela aplikasi
        frame.setVisible(true);
    }
}
