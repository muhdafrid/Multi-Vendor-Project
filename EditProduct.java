import java.sql.*;
import java.util.*;
import inthasstr.*;

public class EditProduct {
    // edit product method
    public static void editProduct(Scanner scan, int vendorId, Connection conn) throws SQLException {
        // int has string validation package
        IntHasStr num = new IntHasStr();

        // get product id else exits
        System.out.print("Enter product ID: ");
        int productId = num.intHasStr();
        while (productId < 0) {
            System.out.println("Invalid Product ID Type! Try Again!");
            return;
        }

        // get new price else exits
        System.out.print("Enter New Price: ");
        double price = num.doubleHasStr();
        while (price < 0) {
            System.out.println("Invalid Product Price Type! Try Again!");
            return;
        }

        // get new quantity else exits
        System.out.print("Enter new quantity: ");
        int quantity = num.intHasStr();
        while (quantity < 0) {
            System.out.println("Invalid Product Quantity Type! Try Again!");
            return;
        }

        // update query
        String updateProductQuery = "UPDATE products SET quantity = ?, price = ? WHERE id = ? AND vendor_key = ?";

        // executs query
        PreparedStatement preparedStatement = conn.prepareStatement(updateProductQuery);
        preparedStatement.setInt(1, quantity);
        preparedStatement.setDouble(2, price);
        preparedStatement.setInt(3, productId);
        preparedStatement.setInt(4, vendorId);
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Invalid product ID or you don't have permission to edit this product.");
        }
    }
}