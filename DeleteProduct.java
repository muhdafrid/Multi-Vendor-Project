import java.sql.*;
import java.util.*;
import inthasstr.*;

public class DeleteProduct {
    // delete method with parameters that throws sql errors
    public static void deleteProduct(Scanner scan, int vendorId, Connection conn) throws SQLException {
        // int has string validation package
        IntHasStr num = new IntHasStr();

        // product id input
        System.out.print("Enter product ID: ");
        int productId = num.intHasStr();
        while (productId < 0) {
            System.out.println("Invalid Product ID Type! Try Again!");
            System.out.print("Enter product ID: ");
            productId = num.intHasStr();
        }

        // delete mysql query
        String deleteProductQuery = "DELETE FROM products WHERE id = ? AND vendor_key = ?";

        // query execution
        PreparedStatement preparedStatement = conn.prepareStatement(deleteProductQuery);
        preparedStatement.setInt(1, productId);
        preparedStatement.setInt(2, vendorId);

        // if rows affected prints deleted else not deleted
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Invalid product ID or you don't have permission to delete this product.");
        }
    }
}