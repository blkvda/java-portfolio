package com.home;

import java.io.*;

public class Main {
    //Проверяемые исключения - наследники Exception (кроме RuntimeException)
    //Непроверяемые исключения - наследники RuntimeException и Error
    //Если недостаточно существующих исключений, можно создавать свои, наследуясь от вышеуказанных
    public static void main(String[] args) {
        System.out.println("Test checked exception");
        printFileByName("./src/test.txt");

        try{
            printFile(new File("./src/test.txt"));
        }
        catch (IOException ex){
            System.out.println("Catch exception in main method");
        }

        System.out.println("Test testReturn method");
        System.out.println("'null': " + testReturn(null));
        System.out.println("'test': " + testReturn("test"));

        System.out.println("Test unchecked exception");
        System.out.println(multPositiveInt(2,3));
        System.out.println(multPositiveInt(-2,3));
    }

    public static int multPositiveInt(int x, int y){
        if(x < 0 || y < 0){
            //unchecked (непроверяемое исключение) - т.е. может никак не обрабатываться -> остановка программы
            throw new IllegalArgumentException("'x' or 'y' < 0");
        }
        return x * y;
    }

    public static void printFileByName(String fileName){
        System.out.println("printFileByName method");
        try{
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String tempString = bufferedReader.readLine();
            while(tempString != null){
                System.out.println(tempString);
                tempString = bufferedReader.readLine();
            }
        }
        //подходящий обработчик исключаений выбирается в порядке записи
        //поэтому записывается пишется частный случай, затем общий
        catch (FileNotFoundException ex){
            System.out.println("Catch exception in printFileByName method");
        }
        catch (IOException ex){
            System.out.println("Catch exception in printFileByName method");
        }
        finally {
            System.out.println("блок finally выполняется вне зависимоти было исключение или нет");
        }
    }

    //если checked исключение не обрабатывается в блоке try/catch
    //то исп. throws для передачи исключения вверх (т.е. вызывающему методу)
    public static void printFile(File file) throws IOException{
        System.out.println("printFile method");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String tempString = bufferedReader.readLine();
        while(tempString != null){
            System.out.println(tempString);
            tempString = bufferedReader.readLine();
        }
    }

    public static String testReturn(String input){
        try{
            if(input == null){
                throw new NullPointerException();
            }
            return "try";
        }
        //multi catch
        catch (NullPointerException | IllegalArgumentException ex){
            return "catch";
        }
//        finally {
//            return "finally";
//        }
    }
}
