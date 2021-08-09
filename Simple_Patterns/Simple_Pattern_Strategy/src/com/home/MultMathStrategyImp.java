package com.home;

//конкретная реализация одной из вариаций алгоритма
public class MultMathStrategyImp implements MathStrategy {
    @Override
    public double calculate(double x, double y) {
        return x * y;
    }
}
