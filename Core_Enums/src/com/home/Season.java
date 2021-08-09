package com.home;

import java.util.Arrays;

public enum Season {
    //принято писать заглавными как все константы
    AUTUMN(new int[]{3, 4, 5}),
    SUMMER(new int[]{6, 7, 8}),
    FALL(new int[]{9, 10, 11}),
    WINTER(new int[]{1, 2, 12});

    private int[] monthsNum;
    //конструктор мб только приватным, для невозмодности создания из вне
    private Season(int[] monthsNum){
        this.monthsNum = monthsNum;
    }
    public void printMonthsNum(){
        System.out.println(String.format("%s months num: %s", this.name(), Arrays.toString(monthsNum)));
    }



}
