package com.home;

public class SumMathStrategyImp implements MathStrategy{
    @Override
    public double calculate(double x, double y) {
        return x + y;
    }
}
