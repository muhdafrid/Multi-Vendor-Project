package strhasint;

import java.util.Scanner;

public class StrHasInt {
    public String strHasInt() {
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine().trim();

        if (str.matches("[a-zA-Z\\s]+")) {
            return str;
        } else {
            return "";
        }
    }
}