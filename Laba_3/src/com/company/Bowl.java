package com.company;

public class Bowl extends Plate {

    protected double mDepth;

    public Bowl(String name, String material, double diameter, double depth) {
        super(name, material, diameter);
        if (depth <= 0) {
            throw new IllegalArgumentException();
        }
        mDepth = depth;
    }

    public double getDepth() {
        return mDepth;
    }

    @Override
    public String getInfo() {
        return this.getClass().getSimpleName() +
                String.format(" [mName=%s, mMaterial=%s]", mName, mMaterial) +
                String.format(" [mDepth=%f]", getDepth());
    }
}
