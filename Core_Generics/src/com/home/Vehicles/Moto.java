package com.home.Vehicles;

public class Moto extends Vehicle {
    String name;

    public Moto(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Moto: " + name;
    }
}
