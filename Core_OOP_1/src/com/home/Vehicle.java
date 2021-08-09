package com.home;

public class Vehicle {
    private static int countOfCreatedVehicles;
    //блок кода - для инициализации статических переменных
    static{
        countOfCreatedVehicles = 0;
    }

    //зкшмфеу модификатор, для инкапсуляции полей класса
    private int wheels;
    private int seats;
    private int weight;

    //конструктор класса - исп. при создании класса, удобен для инициализации переменных
    //в данном случае private поля объекта будут инициализироваться в конструкторе при создании экземпляра
    public Vehicle(int wheels, int seats, int weight) {
        countOfCreatedVehicles++;
        this.wheels = wheels;
        this.seats = seats;
        this.weight = weight;
    }

    //геттеры - для получения значения private переменных
    public int getWheels() {
        return wheels;
    }

    public int getSeats() {
        return seats;
    }

    public int getWeight() {
        return weight;
    }

    public static int getCountOfCreatedVehicles() {
        return countOfCreatedVehicles;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "wheels=" + wheels +
                ", seats=" + seats +
                ", weight=" + weight +
                '}';
    }
}
