package com.home;

public class Main {

    public static void main(String[] args) throws Exception {
        double x = 5;
        double y = 2;
        //Клиент создает экземпляры необходимых стратегий
        MathStrategy mult = new MultMathStrategyImp();
        MathStrategy sum = new SumMathStrategyImp();
        MathStrategy sub = new SubMathStrategyImp();


        MathContext mathContext = new MathContext();
        //клиент определяет экземпляр какой стратегии необходим в настоящий момент и устанавливает его
        mathContext.setMathStrategy(mult);
        System.out.println(String.format("Mult: %.2f * %.2f = %.2f", x, y, mathContext.executeMathStrategy(x, y)));
        mathContext.setMathStrategy(sub);
        System.out.println(String.format("Sub: %.2f - %.2f = %.2f", x, y, mathContext.executeMathStrategy(x, y)));
        mathContext.setMathStrategy(sum);
        System.out.println(String.format("Sum: %.2f + %.2f = %.2f", x, y, mathContext.executeMathStrategy(x, y)));
    }
}
