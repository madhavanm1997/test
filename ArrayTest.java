package java8;

public class ArrayTest {
    public static void main(String[] args) {

        //Array declaration
        System.out.println("Array declaration...");
        int[] array1 = new int[5];
        for (int a1 : array1)
            System.out.println("a1: " + a1);

        //Array Initialization
        System.out.println("Array Initialization...");
        int[] array2 = {2, 3, 4, 6, 4, 3, 9};
        for (int a2 : array2)
            System.out.println(a2);

        //multiple dimension Array
        System.out.println("Multiple dimension array...");
        int[][] multiArray1 = new int[2][2];
        int[][] multiArray2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int[] multiArray3 : multiArray2) {
            for (int multiArray4 : multiArray3) {
                System.out.print(" " + multiArray4);
            }
            System.out.println();
        }
    }
}
