package com.home;

public class Main {
    public static void main(String[] args) {
        //создание переменной, для хранения ссылки класса Vehicle
        Vehicle vehicle;
        //создание экземляра (instance) класса Vehicle и присваивание ссылки переменной vehicle
        vehicle = new Vehicle(3, 2, 315);
        Car car1 = new Car(4, 4, 1120, "spare wheel");
        Motorbike motorbike1 = new Motorbike(2, 2, 145);

        System.out.println(vehicle);
        System.out.println(car1);
        System.out.println(motorbike1);

        //В переменной типа суперкласса может храниться ссылка на экземпляр класса наследника
        Vehicle tempVehicle = car1;
        //По ссылке суперкласса доступны только переменные и методы доступные в суперклассе
        System.out.println("tempVehicle seats: " + tempVehicle.getSeats());
        //для исп. методов экземпляра нужно выполнить преобразование класса
        System.out.println("tempVehicle trunk:" + ((Car) tempVehicle).getTrunk());
        //Методы вызываются согласно классу экземаляра, а не ссылки
        System.out.println("Vehicle tempVehicle хранит ссылку на экземпляр Car: " + tempVehicle.toString());
    }
}
