package com.company;
import java.lang.*;

public class Book {
    private String author;
    private String name;
    private int pages;

    public Book (String a, String c, int b){
        author=a;
        name=c;
        pages=b;
    }

    public int getPages(){
        return pages;
    }

    public String getAuthor() {
        return  author;
    }
    public String getName() {
        return  name;
    }
}
