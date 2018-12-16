package com.company;

public class Student {
    private String name;
    private int ID;

    public Student() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String toString() {
        return "Name: " + this.getName() + "\nID: " + this.getID();
    }
}
