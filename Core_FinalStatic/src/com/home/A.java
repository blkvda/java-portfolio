package com.home;

public class A {
    //final переменная должна быть проинициализирована сразу или в конструкторе
    final int x = 1;
    final int y;

    public A(){
        y = 2;
    }

    public void setX(int x){
        //значение final перемменой нельзя изменить
        //this.x = x;
    }

    //final метод нельзя переопределить
    public final void printHello(){
        System.out.println("Hello");
    }
}
