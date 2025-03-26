package org.javaCar;
import java.util.Scanner;
public interface ErrorChecker {
    Scanner scan = new Scanner(System.in);
    public default int checkIntPos(int max) {
        while (true) {
            if (!scan.hasNextInt()) {
                System.out.println("ERROR: Has de introduir un valor entre 0 i" + max);
                scan.next();
                continue;
            }
            int n = scan.nextInt();
            if (n > max) {
                System.out.println("ERROR: Has de introduir un valor entre 0 i " + max);
                scan.next();
                continue;
            }
            return n;
        }
    }
    public default int checkIntMinMax(int min, int max) {
        while (true) {
            if (!scan.hasNextInt()) {
                System.out.println("ERROR: Has de introduir un valor entre" + min + " i " + max);
                scan.next();
                continue;
            }
            int n = scan.nextInt();
            if (n > max || n < min) {
                System.out.println("ERROR: Has de introduir un valor entre" + min + " i " + max);
                scan.next();
                continue;
            }
            return n;
        }
    }
    public default double checkDoublePos (double max) {
        while (true) {
            if (!scan.hasNextDouble()) {
                System.out.println("ERROR: Has de introduir un valor entre 0 i " + max);
                scan.next();
                continue;
            }
            double n = scan.nextDouble();
            if (n > max) {
                System.out.println("ERROR: Has de introduir un valor entre 0 i " + max);
                scan.next();
                continue;
            }
            return n;
        }
    }
}
