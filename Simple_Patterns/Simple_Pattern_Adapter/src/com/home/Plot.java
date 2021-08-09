package com.home;

public class Plot implements Measurable {
    private double area;

    public Plot(double area) {
        this.area = area;
    }

    @Override
    public double getArea() {
        return area;
    }
}
