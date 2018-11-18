package com.company;

public class Square extends Rectangle {
    public Square()
    {
        this.width = 0;
        this.length = 0;
        this.color = "";
        this.filled = false;
    }
    public Square(double side)
    {
        this.width = side;
        this.length = side;
        this.color = "";
        this.filled = false;
    }
    public Square(double side, String color, boolean filled)
    {
        this.width = side;
        this.length = side;
        this.color = color;
        this.filled = filled;
    }
    public double getSide() {
        return super.getWidth();
    }
    public void setSide(double side) {
        super.setLength(length);
        super.setWidth(width);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
    }

    @Override
    public String toString() {
        return "Shape: width: "+this.getSide()+", color: "+this.color;
    }
}
