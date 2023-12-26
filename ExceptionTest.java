package java8;

import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        int a = 0, b = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a div: ");
        a = scanner.nextInt();
        try {
            throw new ArithmeticException("TEST");

        } catch (Exception e) {
            System.out.println("e: " + e);
            System.out.println("e.getMessage(): " + e.getMessage());
            System.out.println("e.toString(): " + e.toString());
        } finally {
            System.out.println("b: " + b);
        }

        int[] c = {1, 2, 3, 4};
        try {
            //b = 5 / a; //throw a arithmetic error
            b = c[7]; //OutofBoundException error
            System.out.println("a: " + a);
        } catch (ArithmeticException e) {
            System.out.println("e.getMessage(): " + e.getMessage());
            System.out.println("e: " + e);
        } finally {
            System.out.println("b: " + b);
        }
    }
}
