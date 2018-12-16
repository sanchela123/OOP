
package com.company;
import java.util.Scanner;

public class Main {
    public static Scanner input;

    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("Enter amount of students:");
        int n = checkVariable(1);
        StudentArray array = new StudentArray();
        array.createArray(n);
        array.writeArrayAuto();
        array.readArray();
        array.sortHoar(0, array.iDNumber.length - 1);
        System.out.println("Sorted Array:");
        array.readArray();
    }

    static int checkVariable(int min) {
        boolean var1 = false;

        while(true) {
            while(input.hasNextInt()) {
                int n = input.nextInt();
                if (n < min) {
                    System.out.println("ERROR!");
                }

                if (n >= min) {
                    return n;
                }
            }

            System.out.println("ERROR!");
            input.nextLine();
        }
    }

    static {
        input = new Scanner(System.in);
    }
}