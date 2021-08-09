package com.home.Planes;

public class Boeing extends Plane{
    String name;

    public Boeing(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Boeing: " + name;
    }
}
