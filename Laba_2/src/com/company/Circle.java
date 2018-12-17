package com.company;

public class Circle {

        private double mRadius;

    public Circle(double radius) {
            if (radius <= 0) {
                throw new IllegalArgumentException("Radius should be greater than 0");
            }
            mRadius = radius;
        }

        public double getRadius() {
            return mRadius;
        }

        public void setRadius(double radius) {
            if (radius <= 0) {
                throw new IllegalArgumentException("Radius should be greater than 0");
            }
            mRadius = radius;
        }

        public double getDiameter() {
            return mRadius * 2;
        }

        public double getArea() {
            return mRadius * mRadius * Math.PI;
        }

        public double getPerimeter() {
            return mRadius * 2 * Math.PI;
        }

        @Override
        public String toString() {
            return "Circle{" +
                    "mRadius=" + mRadius +
                    '}';
        }
    }