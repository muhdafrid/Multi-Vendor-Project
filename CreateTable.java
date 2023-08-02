import java.sql.*;

public class CreateTable {
    // create table method
    public static void createTablesIfNotExist(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        // create table mysql query
        String createVendorsTable = "CREATE TABLE IF NOT EXISTS vendors (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "email VARCHAR(100) NOT NULL," +
                "password VARCHAR(100) NOT NULL," +
                "created_at DATETIME DEFAULT CURRENT_TIMESTAMP)";
        stmt.executeUpdate(createVendorsTable);

        // create table mysql query
        String createProductsTable = "CREATE TABLE IF NOT EXISTS products (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "vendor_key INT NOT NULL," +
                "name VARCHAR(100) NOT NULL," +
                "price DECIMAL(10, 2) NOT NULL," +
                "quantity INT NOT NULL," +
                "description VARCHAR(500) NOT NULL," +
                "FOREIGN KEY (vendor_key) REFERENCES vendors(id) ON DELETE CASCADE)";
        stmt.executeUpdate(createProductsTable);
    }
}