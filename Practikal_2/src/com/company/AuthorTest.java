package com.company;

public class AuthorTest {

    public static void main(String[] args) {
        Author a1= new Author("Twen","twen@gmail.com",'m');
        System.out.println(a1.ToString());
        a1.setEmail("twen2@mail.ru");
        System.out.println(a1.ToString());
    }
}
