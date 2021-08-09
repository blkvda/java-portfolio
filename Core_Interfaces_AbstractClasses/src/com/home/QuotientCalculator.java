package com.home;

//неабстрактный класс должен реализовывать все абсрактные методы
public class QuotientCalculator extends AbstractCalculator {
    public QuotientCalculator() {
        this.description = "quotient calculator - возвращает частное от деления";
    }

    @Override
    public int div(int x, int y) {
        return x / y;
    }
}
