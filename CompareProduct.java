import java.sql.*;
import java.util.*;

public class CompareProduct {
    // compare products method with parameter that throws mysql errors
    public static void comparePrices(Scanner scan, int vendorId, Connection conn) throws SQLException {

        // get product name
        System.out.print("Enter product name: ");
        String name = scan.nextLine();

        // mysql query to get average price of the product except ours
        String selectAvgPriceQuery = "SELECT AVG(price) AS avg_price FROM products WHERE name = ? AND vendor_key <> ?";

        // mysql query executtion
        PreparedStatement preparedStatement = conn.prepareStatement(selectAvgPriceQuery);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, vendorId);

        // gets that value
        ResultSet rs = preparedStatement.executeQuery();

        // prints that value
        if (rs.next()) {
            double avgPrice = rs.getDouble("avg_price");
            System.out.println("Average market price for '" + name + "': $" + avgPrice);
        } else {
            System.out.println("No products found with the given name.");
        }
    }
}