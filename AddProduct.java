import java.sql.*;
import java.util.*;
import inthasstr.*;

public class AddProduct {
    public static void addProduct(Scanner scan, int vendorId, Connection conn) throws SQLException {
        IntHasStr num = new IntHasStr();
        System.out.print("Enter product name: ");
        String name = scan.nextLine();

        //check if that product name is already added
        String query = "select count(name) from products where name = ? and vendor_key = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, vendorId);
        ResultSet rs1 = preparedStatement.executeQuery();
        int noOf = 0;
        while(rs1.next()) {
            noOf = rs1.getInt("count(name)");
        }
        if(noOf != 0) {
            System.out.println("Can't Add Two Products With Same Name.");
            return;
        }

        System.out.print("Enter product price: ");
        double price = num.doubleHasStr();
        while(price < 0) {
            System.out.println("Invalid Product Price Type! Try Again!");
            System.out.print("Enter product price: ");
            price = num.doubleHasStr();
        }

        System.out.print("Enter product quantity: ");
        int quantity = num.intHasStr();
        while(quantity < 0) {
            System.out.println("Invalid Product Quantity Type! Try Again!");
            System.out.print("Enter product price: ");
            quantity = num.intHasStr();
        }

        System.out.print("Enter product description: ");
        String description = scan.nextLine();

        //inserts all value
        String insertProductQuery = "INSERT INTO products (vendor_key, name, price, quantity, description) " +
                "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement2 = conn.prepareStatement(insertProductQuery);
        preparedStatement2.setInt(1, vendorId);
        preparedStatement2.setString(2, name);
        preparedStatement2.setDouble(3, price);
        preparedStatement2.setInt(4, quantity);
        preparedStatement2.setString(5, description);
        preparedStatement2.executeUpdate();

        //to print the product id of the product thats just added
        String productIdQuery = "select id from products where name = ?";
        PreparedStatement preparedStatement3 = conn.prepareStatement(productIdQuery);
        preparedStatement3.setString(1, name);
        ResultSet rs = preparedStatement3.executeQuery();

        int productId = 0;
        while(rs.next()) {
            productId = rs.getInt("id");
        }

        System.out.println("Product added successfully! Product ID: " + productId);
    }
}