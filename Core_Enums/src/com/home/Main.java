package com.home;

public class Main {

    public static void main(String[] args) {
        //вывод порядкового номера, согласно объявлению
        System.out.println(Season.SUMMER.ordinal());
        //вывод имени
        System.out.println(Season.SUMMER.name());

        Season s = Season.AUTUMN;
        s.printMonthsNum();
        //можно исп в switch
        switch (s){
            case AUTUMN:
            case SUMMER:
            case FALL:{
                System.out.println("Here is warm enough");
                break;
            }
            case WINTER:{
                System.out.println("Here is cold");
                break;
            }
        }

        //нельзя непосредственно сравнивать с int
        //switch (s){
        //    case 0:
        //    case 1:
        //    case 2:{
        //        System.out.println("Here is warm enough");
        //        break;
        //    }
        //    case 3:{
        //        System.out.println("Here is cold");
        //        break;
        //    }
        //}
    }
}
