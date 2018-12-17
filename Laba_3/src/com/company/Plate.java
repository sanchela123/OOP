package com.company;

public class Plate extends Dish {

    protected double mDiameter;

    public Plate(String name, String material, double diameter) {
        super(name, material);
        if (diameter <= 0) {
            throw new IllegalArgumentException();
        }

        mDiameter = diameter;
    }

    public double getDiameter() {
        return mDiameter;
    }

    @Override
    public String getInfo() {
        return this.getClass().getSimpleName() +
                String.format(" [mName=%s, mMaterial=%s]", mName, mMaterial) +
                String.format(" [mDiameter=%f]", getDiameter());
    }
}