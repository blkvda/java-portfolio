package com.home;

//final класс нельзя наследовать
public final class B extends A{
    //final метод нельзя переопределить
    //@Override
    //public void printHello(){
    //    System.out.println("Hello");
    //}

    int x = 1;
    static int y = 2;

    //к static полям и методам можно обращаться по имени класса, экземпляр класса не нужен
    static void printInt(){
        //static метод может обращаться только у другим static полям и методам
        //System.out.println("printInt x = " + x);
        System.out.println("static y = " + y);

        //если метод или поле не static, то нужен экземпляр класса
        B b = new B();
        System.out.println("non static x = " + b.x);
    }
}
