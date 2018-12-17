package com.company;

public class Main {

    public static void main(String[] args) {
        Dish dish1 = new Plate("Plate", "Glass", 12);
        Dish dish2 = new Bowl("Bowl", "Glass", 8, 3);

        System.out.println(dish1.getInfo());
        System.out.println(dish2.getInfo());
    }
}