package com.home;

//extends - кл. слова для наследования класса
//наследуются в том числе приватные поля и методы, но в классе наследнике напрямую не мб использованы, но мб исп через методы
public class Motorbike extends Vehicle {
    public Motorbike(int wheels, int seats, int weight) {
        super(wheels, seats, weight);
    }

    public void doWilly(){
        System.out.println("WILLY");
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "wheels=" + this.getWheels() +
                ", seats=" + this.getSeats() +
                ", weight=" + this.getWeight() +
                '}';
    }
}
