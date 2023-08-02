package inthasstr;  //package created

import java.util.*; //package imported

public class IntHasStr {    //package class
    Scanner scan = new Scanner(System.in);  //scanner object

    public byte byteHasStr() { //return byte if the input is byte else return -1
        byte integer;
        try {
            integer = scan.nextByte();
            return integer;
        } catch (InputMismatchException e) {
            scan.nextLine();
            return -1;
        }
    }

    public int intHasStr() { //return int if the input is int else return -1
        int integer;
        try {
            integer = scan.nextInt();
            return integer;
        } catch (InputMismatchException e) {
            scan.nextLine();
            return -1;
        }
    }

    public double doubleHasStr() { //return double if the input is double else return -1
        double integer;
        try {
            integer = scan.nextDouble();
            return integer;
        } catch (InputMismatchException e) {
            scan.nextLine();
            return -1;
        }
    }

    public long longHasStr() {  //return long if the input is long else return -1
        long integer;
        try {
            integer = scan.nextLong();
            return integer;
        } catch (InputMismatchException e) {
            scan.nextLine();
            return -1;
        }
    }
}