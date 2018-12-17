package com.company;

public abstract class Dish {

    protected String mName;
    protected String mMaterial;

    public Dish(String name, String material) {
        if (name == null || material == null) {
            throw new IllegalArgumentException();
        }

        mName = name;
        mMaterial = material;
    }

    public String getName() {
        return mName;
    }

    public String getMaterial() {
        return mMaterial;
    }

    public abstract String getInfo();
}

