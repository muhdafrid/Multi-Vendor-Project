import java.sql.*;

public class ViewProducts {

    // view product method with parameter throws mysql errors
    public static void viewProducts(Connection conn, int vendorId) throws SQLException {
        
        // mysql query to print all products with my vendor id
        String query = "Select * from products where vendor_key = " + vendorId;
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            System.out.println("Product Id: " + rs.getInt("id") + " Vendor Id: " + rs.getInt("vendor_key")
                    + " Product Name: " + rs.getString("name") +
                    " Product Price: " + rs.getBigDecimal("price") + " Product Quantity: " + rs.getInt("quantity")
                    + " Product Description: " + rs.getString("description"));
        }
    }
}