package com.company;

public class Circle extends Shape {
    protected double radius;
    public Circle(){
        radius=0;
        this.color= "";
        this.filled= false;
    }

    public Circle(double radius){
        this.radius=radius;
        this.color= "";
        this.filled= false;
    }

    public Circle(double radius, String color, boolean filled){
        this.radius=radius;
        this.color= color;
        this.filled= filled;
    }

    public double getRadius(){
        return radius;
    }

    public void setRadius(double radius){
        this.radius=radius;
    }


    @Override
    double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    double getPerimeter() {
        return Math.PI*radius*2;
    }

    @Override
    public String toString() {
        return "Shape: circle, radius: "+this.radius+", color: "+this.color;
    }
}
