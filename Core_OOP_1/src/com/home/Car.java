package com.home;

//extends - кл. слова для наследования класса
//наследуются в том числе приватные поля и методы, но в классе наследнике напрямую не мб использованы, но мб исп через методы
public class Car extends Vehicle {
    private String trunk;

    public Car(int wheels, int seats, int weight, String trunk) {
        //т.к. у родителького класса нет пустого конструктора
        super(wheels, seats, weight);
        this.trunk = trunk;
    }

    public Car(int wheels, int seats, int weight) {
        super(wheels, seats, weight);
    }

    //геттеры и сеттеры для работы с private переменными
    public String getTrunk() {
        return trunk;
    }

    public void setTrunk(String trunk) {
        this.trunk = trunk;
    }

    @Override
    public String toString() {
        return "Car{" +
                "trunk='" + trunk + '\'' +
                ", wheels=" + this.getWheels() +
                ", seats=" + this.getSeats() +
                ", weight=" + this.getWeight() +
                '}';
    }
}
