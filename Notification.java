import java.sql.*;

class Notification {
    public static void productNotication(Connection conn, int vendorId) throws SQLException {
        // mysql query to check the no Of Quantity Of A Product
        String notificationQuery = "select * from products where quantity < 100 and vendor_key = " + vendorId;

        PreparedStatement preparedStatement = conn.prepareStatement(notificationQuery);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            System.err.println(
                    "\nALERT! Quantity Of " + rs.getString("name") + " IS Very Low (" + rs.getInt("quantity") + ")\n");
        }
    }
}