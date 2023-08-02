import java.io.Console;
import java.sql.*;
import java.util.*;

public class Login {

    //login method
    public static void login(Scanner scan, Connection conn) throws SQLException {

        System.out.print("Enter vendor email: ");
        String email = scan.nextLine();

        //console to hide password
        System.out.print("Enter Your Password: ");
        char[] password1 = System.console().readPassword();
        String password = "";
        for (char i : password1) {
            password += i;
        }

        // checks if the details are correct
        String selectVendorQuery = "SELECT * FROM vendors WHERE email = ? AND password = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(selectVendorQuery);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            int vendorId = rs.getInt("id");
            System.out.println("Login successful! Vendor ID: " + vendorId);
            Menu.showVendorMenu(scan, vendorId, conn);
        } else {
            System.out.println("Invalid credentials! Please try again.");
        }
    }
}