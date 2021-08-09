package com.home;

import java.io.*;

public class Main {

    public static void main(String[] args){
        //File - каталог или файл
        File checkingDir = new File("./MyDirectory");
        printFileTreeContent(checkingDir, 0);

        try{
            //Создание нового файла
            boolean created = new File(checkingDir, "about.txt").createNewFile();
            if(created){
                System.out.println("New File was created");
            }
            else{
                throw new IOException("Can't create new File");
            }

            //запись данных в файл
            //использование некоторых классов - оберток
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(checkingDir, "about.txt"))));
            bufferedWriter.write("First test line");
            bufferedWriter.newLine();
            bufferedWriter.write("Second and last test line");
            bufferedWriter.flush();
            bufferedWriter.close();

            //перенос(также можно переименовать) файла в другой каталог
            File renameFrom = new File("./MyDirectory/about.txt");
            File renameTo = new File(renameFrom.getParentFile(), "/Texts/aboutVideoCards.txt");
            renameFile(renameFrom, renameTo);
            printFileTreeContent(checkingDir, 0);

            //вывод данных из файла в косноль
            //Reader, Writer - символьные потоки ввода/вывода
            //InputStream, OutputStream - байтовые потоки иввода/вывода

            //исп try with resources для автоматического закрытия
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(renameFrom.getParentFile(), "/Texts/aboutVideoCards.txt")))) {
                String tempString;
                while ((tempString = bufferedReader.readLine()) != null){
                    System.out.println(tempString);
                }
            }

            //удаление файла
            if(renameTo.delete()){
                System.out.println("File successful deleted");
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }


        Car myCar = new Car("Skoda", 1998, 1212332);
        System.out.println("Before serialization: " + myCar);
        serializeCar(myCar, new File("./serializedCar.data"));
        Car deserializedMyCar = deserializeCar(new File("./serializedCar.data"));
        System.out.println("After deserialization: " + deserializedMyCar);

    }

    private static void printFileTreeContent(File file, int nestingLevel){
        if(file.exists()){
            for(int i = 0; i < nestingLevel+1; i++){
                System.out.print("\t");
            }
            if(file.isDirectory()){
                System.out.print(String.format("directory: %s", file.getName()));
                System.out.println();
                for(File f : file.listFiles()){
                    printFileTreeContent(f, ++nestingLevel);
                }
            }
            else{
                System.out.print(String.format("file: %s", file.getName()));
                System.out.println();
            }
        }
        else{
            System.out.println("File doesn't exists");
        }
    }

    private static boolean renameFile(File renameFrom, File renameTo){
        return renameFrom.renameTo(renameTo);
    }

    private static void serializeCar(Car car, File fileSerializeDest){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileSerializeDest))){
            objectOutputStream.writeObject(car);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private static Car deserializeCar(File fileDeserializeLocation){
        Car result = null;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileDeserializeLocation))){
            Object deserializedObject = objectInputStream.readObject();
            if(deserializedObject instanceof Car){
                result = (Car)deserializedObject;
            }
            else{
                throw new IOException("Incorrect Object for deserialization");
            }
        }
        catch (IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        finally {
            return result;
        }
    }
}
