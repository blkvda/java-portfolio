package com.home;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String temp;
        StringBuilder sb = new StringBuilder();
        System.out.println("Enter your text. Print 'exit' to stop process");
        while (!(temp = scanner.nextLine()).equals("exit")){
            sb.append(temp + "\n");
        }

        File file = new File("./myData.txt");
        writeInFile(file, sb);
        printFromFile(file);
    }

    public static void writeInFile(File fileDest, StringBuilder stringBuilder){
        try{
            System.out.println("Write data in File");
            FileWriter fileWriter = new FileWriter(fileDest);
            fileWriter.write(stringBuilder.toString());
            fileWriter.flush();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private static void printFromFile(File fileDest){
        try{
            Scanner scanner = new Scanner(fileDest);
            System.out.println("Read data from File");
            while (scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
