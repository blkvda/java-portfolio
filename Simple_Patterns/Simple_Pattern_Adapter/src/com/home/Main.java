package com.home;

public class Main {

    public static void main(String[] args) {
        Measurable home = new Plot(2500);
        double areaM2 = new MeasurableAdapterImp(home).getArea();
        System.out.println(String.format("Area: %.2f ft^2 equals %.2f m^2", home.getArea(), areaM2));
    }
}
