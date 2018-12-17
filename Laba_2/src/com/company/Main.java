package com.company;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);

        System.out.println(String.format("Here is the circle:\n%s", circle.toString()));

        System.out.println(String.format("Diameter: %f", circle.getDiameter()));
        System.out.println(String.format("Area: %f", circle.getArea()));
        System.out.println(String.format("Perimeter: %f", circle.getPerimeter()));

        circle.setRadius(10);

        System.out.println(String.format("\nNow circe:\n%s", circle.toString()));

        System.out.println(String.format("Diameter: %f", circle.getDiameter()));
        System.out.println(String.format("Area: %f", circle.getArea()));
        System.out.println(String.format("Perimeter: %f", circle.getPerimeter()));
    }
}