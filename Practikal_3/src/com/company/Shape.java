package com.company;

public abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape(){
        this.color = " ";
        this.filled = false;
    }

    public Shape(String a, boolean b){
        this.color = color;
        this.filled = filled;
    }

    public String getColor(){
        return color;
    }

    public boolean IsFilled(){
        return filled;
    }

    public void setColor(String color){
        this.color=color;
    }

    public void setFilled(boolean filled){
        this.filled=filled;
    }

    abstract double getArea();
    abstract double getPerimeter();
    public abstract String toString();
}
