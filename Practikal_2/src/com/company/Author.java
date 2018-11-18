package com.company;


public class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String a,String b,char c){
        name=a;
        email=b;
        gender=c;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public char getGender(){
        return gender;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String ToString(){
        return ("Author - " + name + " Email -" + this.email + " Gender - " + gender);
    }

}
