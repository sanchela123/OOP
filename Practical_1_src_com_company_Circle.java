package com.company;
import java.lang.*;

//Circle.java
public class Circle {
    private double rad;
    private String color;

    public Circle(){
        rad=5.0;
        color="blue";
    }
    public Circle(double a){
        rad = a;
        color="orange";
    }

    public Circle(double a, String b){
        rad=a;
        color=b;
    }

    public double getRadius(){
        return rad;
    }

    public String getColor(){
        return color;
    }

    public double getArea(){
        return rad*rad*Math.PI;
    }
}
