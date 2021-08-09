package com.home;

//неабстрактный класс должен реализовывать все абсрактные методы
public class RemainderCalculator extends AbstractCalculator {
    public RemainderCalculator() {
        this.description = "remainder calculator - возвращает остаток от деления";
    }

    @Override
    public int div(int x, int y) {
        return x % y;
    }
}
