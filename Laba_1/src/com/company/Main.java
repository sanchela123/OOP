package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размер массива:\n");
        int length;
        if (scanner.hasNextInt()) {
            length = scanner.nextInt();
            scanner.nextLine();
            if (length <= 0) {
                System.out.println("Неверный ввод");
            }
        } else {
            System.out.println("Неверный ввод");
            return;
        }


        int[] arr = createArr(length);
        printArr(arr);
        Arrays.sort(arr);
        printArr(arr);

        System.out.println("Для выхода нажмите enter...");
        scanner.nextLine();
    }


    public static int[] createArr(int length) {
        int[] arr = new int[length];

        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt();
        }

        return arr;
    }

    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }

        System.out.println();
    }
}
