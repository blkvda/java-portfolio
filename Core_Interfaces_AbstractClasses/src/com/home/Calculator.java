package com.home;

//extends - кл. сл. мб. использовано для наследования интерфейса интерфейсом
public interface Calculator{
    //в интерфейсах можно объявлять константы
    int TYPE_ID = 123;

    //мб статические методы
    static void printTypeId(){
        System.out.println("TYPE_ID: " + TYPE_ID);
    }

    //метод по умолчанию - реализация уже представляется интерфейсом, но можно переопределить в классе
    default int add(int x, int y){
        return x + y;
    }

    int sub(int x, int y);
    int div(int x, int y);
    int mult(int x, int y);
}
