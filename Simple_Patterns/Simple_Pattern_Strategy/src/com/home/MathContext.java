package com.home;

//Контекст хранит ссылку на конкретный экземпляр стратегии, работая через общий интерфейс
//при вызове метода делегирует выполнение задачи конкретной реализации алгоритма
public class MathContext {
    private MathStrategy mathStrategy;

    public void setMathStrategy(MathStrategy mathStrategy) {
        this.mathStrategy = mathStrategy;
    }

    public double executeMathStrategy(double x, double y) throws Exception{
        if(mathStrategy != null) {
            return mathStrategy.calculate(x, y);
        }
        else {
            throw new Exception(this.getClass().getSimpleName() + ": mathStrategy =- null");
        }
    }
}
