package com.home;

public class Main {

    public static void main(String[] args) {
        //Экземпляр интерфейса создать нельзя
        //Calculator calculator = new Calculator();

        //Экземпляр абстрактного класса создать нельзя
        //Calculator calculator = new AbstractCalculator();

        //исп. полиморфизм - применется для создания слабосвязанных приложений
        Calculator quitCalc = new QuotientCalculator();
        Calculator remainderCalc = new RemainderCalculator();
        AbstractCalculator calc = new QuotientCalculator();

        int x = 5, y = 2;
        System.out.println(String.format("x = %d\ty = %d",x, y));
        System.out.println(String.format("Calculator: %s\nadd = %d\nsub = %d\ndiv = %d\nmult = %d",
                ((QuotientCalculator) quitCalc).getDescription(), //преведение типа, т.к. интерфейс не имеет этого vtnjlf
                quitCalc.add(x, y),
                quitCalc.sub(x, y),
                quitCalc.div(x, y),
                quitCalc.mult(x, y)));
        System.out.println(String.format("Calculator: %s\nadd = %d\nsub = %d\ndiv = %d\nmult = %d",
                ((RemainderCalculator) remainderCalc).getDescription(),
                remainderCalc.add(x, y),
                remainderCalc.sub(x, y),
                remainderCalc.div(x, y),
                remainderCalc.mult(x, y)));
        System.out.println(String.format("Calculator: %s\nadd = %d\nsub = %d\ndiv = %d\nmult = %d",
                calc.description,
                calc.add(x, y),
                calc.sub(x, y),
                calc.div(x, y),
                calc.mult(x, y)));
    }
}
