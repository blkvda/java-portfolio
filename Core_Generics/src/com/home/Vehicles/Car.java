package com.home.Vehicles;

public class Car extends Vehicle {
    String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car: " + name;
    }
}
