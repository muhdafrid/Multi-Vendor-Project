import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import strhasint.*;

class Signup {

    //email validation method
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    //signup method
    public static void registerVendor(Scanner scan, Connection conn) throws SQLException {
        StrHasInt str = new StrHasInt();

        //ask vendor name
        System.out.print("Enter vendor name: ");
        String name = str.strHasInt();
        while (name.length() < 1) {
            System.out.println("Invalid Name Type! Try Again!");
            System.out.print("Enter vendor name: ");
            name = str.strHasInt();
        }

        //asks vendor email id
        System.out.print("Enter vendor email: ");
        String email = scan.nextLine();

        //checks if the email is valid
        if (isValidEmail(email)) { //if valid

            String checkEmailQuery = "SELECT COUNT(*) AS count FROM vendors WHERE email = ?";
            PreparedStatement checkEmailStmt = conn.prepareStatement(checkEmailQuery);
            checkEmailStmt.setString(1, email);
            ResultSet emailResult = checkEmailStmt.executeQuery();

            //if that email already exist
            if (emailResult.next()) {
                int count = emailResult.getInt("count");
                if (count > 0) {

                    //prints already exist
                    System.out.println("This Email is already registered.");
                    return;
                }
            }

            //else continues to ask vendor password
            System.out.print("Enter vendor password: ");
            String password = scan.nextLine();
            while (password.length() < 8) {
                System.out.println("Password Must Be Atleast 8 Charecters Long.");
                System.out.print("Enter vendor password: ");
                password = scan.nextLine();
            }

            //insert all details
            String insertVendorQuery = "INSERT INTO vendors (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertVendorQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();

            System.out.println("Vendor registered successfully!");
        } else {
            System.out.println("Invalid Email! Try Again!");
        }
    }
}