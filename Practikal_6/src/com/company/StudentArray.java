package com.company;

import java.util.Random;

class StudentArray {
    public Student[] iDNumber;

    StudentArray() {
    }

    public void createArray(int n) {
        this.iDNumber = new Student[n];

        for(int i = 0; i < n; ++i) {
            this.iDNumber[i] = new Student();
        }

    }

    void sortHoar(int first, int last) {
        if (first < last) {
            int mid = first + (last - first) / 2;
            this.iDNumber[mid] = this.swap(this.iDNumber[first], this.iDNumber[first] = this.iDNumber[mid]);
            int i = first + 1;
            int j = last;

            while(i <= j) {
                while(i <= j && this.iDNumber[i].getID() <= this.iDNumber[first].getID()) {
                    ++i;
                }

                while(i <= j && this.iDNumber[j].getID() > this.iDNumber[first].getID()) {
                    --j;
                }

                if (i < j) {
                    this.iDNumber[i] = this.swap(this.iDNumber[j], this.iDNumber[j] = this.iDNumber[i]);
                }
            }

            this.iDNumber[i - 1] = this.swap(this.iDNumber[first], this.iDNumber[first] = this.iDNumber[i - 1]);
            int part = i - 1;
            this.sortHoar(first, part - 1);
            this.sortHoar(part + 1, last);
        }
    }

    private Student swap(Student a, Student b) {
        return a;
    }

    public void writeArray() {
        for(int i = 0; i < this.iDNumber.length; ++i) {
            this.iDNumber[i].setName(Main.input.nextLine());
            this.iDNumber[i].setID(Main.checkVariable(1));
        }

    }

    public void writeArrayAuto() {
        for(int i = 0; i < this.iDNumber.length; ++i) {
            Random random = new Random();
            this.iDNumber[i].setName(this.makeRandomString());
            this.iDNumber[i].setID(Math.abs(random.nextInt()));
        }

    }

    public void readArray() {
        for(int i = 0; i < this.iDNumber.length; ++i) {
            System.out.println(this.iDNumber[i]);
            System.out.println();
        }

    }

    private String makeRandomString() {
        Random random = new Random();
        String temp = "";
        int n = Math.abs(random.nextInt()) % 10 + 1;

        for(int i = 0; i < n; ++i) {
            temp = temp + (char)(Math.abs(random.nextInt()) % 26 + 97);
        }

        return temp;
    }
}
