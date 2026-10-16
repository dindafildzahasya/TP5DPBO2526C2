import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private Connection connection;
    private Statement statement;

    // Constructor untuk menghubungkan Java ke MySQL
    public Database() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_anggotaPerpus",
                    "root",
                    ""
            );

            statement = connection.createStatement();

            System.out.println("Koneksi database berhasil!");
        } catch (SQLException e) {
            throw new RuntimeException(
                    "Koneksi database gagal: " + e.getMessage(), e
            );
        }
    }

    // Menjalankan query SELECT
    public ResultSet selectQuery(String sql) {
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Menjalankan query INSERT, UPDATE, dan DELETE
    public int insertUpdateDeleteQuery(String sql) {
        try {
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Getter statement
    public Statement getStatement() {
        return statement;
    }
}