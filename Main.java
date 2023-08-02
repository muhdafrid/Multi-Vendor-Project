import java.sql.*;
import java.util.*;
import inthasstr.*;

public class Main {
    public static Connection conn;

    public static void main(String[] args) throws SQLException {
        IntHasStr num = new IntHasStr();

        //mysql connection
        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vendors", "root", "Muhd_afrid16");
        CreateTable.createTablesIfNotExist(conn);

        Scanner scan = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Register Vendor");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = num.intHasStr();
            while (choice < 0) {
                System.out.println("Invalid Option! Try Again!");
                System.out.println("1. Register Vendor");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = num.intHasStr();
            }

            switch (choice) {
                case 1:
                    Signup.registerVendor(scan, conn);
                    break;
                case 2:
                    Login.login(scan, conn);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}