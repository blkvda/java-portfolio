package com.home;

//implements - кл.сл. для реализации интерфейса
public abstract class AbstractCalculator implements Calculator {
    //абстрактный класс может содержать собственные переменные и методы (в т.ч. абсрактные методы)
    String description = "abstract calculator";

    protected String getDescription(){
        return description;
    }

    //абстрактный класс может реализовывать абстрактные методы интерфейса
    @Override
    public int sub(int x, int y) {
        return x - y;
    }

    @Override
    public int mult(int x, int y) {
        return x * y;
    }
}
