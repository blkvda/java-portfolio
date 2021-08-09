package com.home;

public class SubMathStrategyImp implements MathStrategy {
    @Override
    public double calculate(double x, double y) {
        return x - y;
    }
}
