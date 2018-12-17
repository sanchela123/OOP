package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        try(FileWriter writer = new FileWriter("C:/Users/sanchela123/IdeaProjects/Laba_8/out/notes3.txt", false))
        {
            // запись всей строки
            writer.write(text);
            writer.append('\n');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
