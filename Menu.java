import java.sql.*;
import java.util.*;
import inthasstr.*;

public class Menu {
    // menu method with parameter that throws sqlerrors
    public static void showVendorMenu(Scanner scan, int vendorId, Connection conn) throws SQLException {
        Notification.productNotication(conn, vendorId);
        // int has string validation package
        IntHasStr num = new IntHasStr();

        boolean logout = false;
        while (!logout) {
            System.out.println("1. Add Product");
            System.out.println("2. Compare Prices");
            System.out.println("3. Edit Product");
            System.out.println("4. Delete Product");
            System.out.println("5. My Products");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            int choice = num.intHasStr();
            while (choice < 0) {
                System.out.println("1. Add Product");
                System.out.println("2. Compare Prices");
                System.out.println("3. Edit Product");
                System.out.println("4. Delete Product");
                System.out.println("5. My Products");
                System.out.println("6. Logout");
                System.out.print("Enter your choice: ");
                choice = num.intHasStr();
            }

            switch (choice) {
                case 1:
                    AddProduct.addProduct(scan, vendorId, conn);
                    break;
                case 2:
                    CompareProduct.comparePrices(scan, vendorId, conn);
                    break;
                case 3:
                    EditProduct.editProduct(scan, vendorId, conn);
                    break;
                case 4:
                    DeleteProduct.deleteProduct(scan, vendorId, conn);
                    break;
                case 5:
                    ViewProducts.viewProducts(conn, vendorId);
                    break;
                case 6:
                    logout = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}