package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        //Serializable
        String filePathUser =  "user.txt";
        User user = new User(0, 10, "Tomas");
        writeObject(user, filePathUser);
        System.out.println(readObject(filePathUser));

        //Externalizable
        String filePathCar = "car.txt";
        Car car = new Car(1, 5, "ABCD123EFGH45#", "Honda", "Civic");
        writeObject(car, filePathCar);
        System.out.println(readObject(filePathCar));
    }
    //сериализация объекта
    public static boolean writeObject(Object object, String filePath){
        try(ObjectOutputStream objectOutputStream =  new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(object);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    //десериализация объекта
    public static Object readObject(String filePath){
        Object obj = null;
        try(ObjectInputStream objectInputStream =  new ObjectInputStream(new FileInputStream(filePath))){
            obj = objectInputStream.readObject();
            if(obj instanceof User){
                System.out.println("It's User");
            }
            else if (obj instanceof Car){
                System.out.println("It's Car");
            }
            else{
                System.out.println("Unknown class");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            return obj;
        }
    }

}

