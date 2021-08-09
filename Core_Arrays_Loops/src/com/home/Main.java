package com.home;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //инициализация массива значениями по умолчанию
        int[] arr1 = new int[5];
        //инициализация массива конкретными значениями
        int[] arr2 = {1, 22, 333};
        int[] arr3 = new int[]{1, 3, 5};
        //многомерный массив
        int[][] arr4 = {{11, 12, 13, 14}, {21, 22}};
        //установка значения элемента массива по индексу
            //нумерация индексов массива начинается с 0, конец = (длина массива - 1)
        arr1[0] = 987;

        //цикл while пока условие true
        int x = 3;
        System.out.print("'x' counter: ");
        while(x > 0){
            System.out.print(x + " ");
            x--;
        }
        System.out.println();

        int a = 5;
        int b = 10;
        //условная структура управления
        if(a > b){
            System.out.println("a > b");
        } else if(a < b){
            System.out.println("a < b");
        }
        else {
            System.out.println("a = b");
        }
        //цикл do-while выполняется как минимум 1 раз
        int y = 0;
        System.out.print("\n'y' counter: ");
        do{
            System.out.print(y + " ");
        }while (y > 0);

        //цикл for
        System.out.print("\narr3: ");
        //length - хранит значение длины массива
        for(int i = 0; i < arr3.length; i++){
            System.out.print(arr3[i] + " ");
        }

        //проход по многомерному массиву с использованием foreach
        System.out.print("\nMultidimensional arr4:");
        for(int[] i : arr4){
            for(int j : i){
                //печать четных элементов без изменения
                if(j % 2 == 0){
                    System.out.print(" " + j);
                }
                //печать нечетных элементов умноженных на 2
                else{
                    System.out.print(" " + j*2);
                }
            }
        }
        System.out.println();


        for(int i = 0; i < 5; i += 2){
            checkInt(i);
        }

        //Arrays - методы для работы с массивами
        System.out.println("arr2: " + Arrays.toString(arr2));   //для печати элементов массива
        Arrays.fill(arr2, 1, arr2.length, 99999);   //для заполнения элементов массива
        System.out.println("arr2: " + Arrays.toString(arr2));
        System.out.println("arr4: " + Arrays.deepToString(arr4));   //для печати элементов многомерных массивов
    }

    public static void checkInt(int x){
        //switch может исп byte, short, char, int (+ Wrappers), String, Enum
        switch (x){
            case (1):{
                System.out.println("x = 1\t(x = " + x + ")");
                break;
            }
            case (2):{
                //если нет break, то выполняется следующая конструкция case (до break или до конца)
            }
            case (3):{
                System.out.println("x = 2 or x = 3\t(x = " + x + ")");
                break;
            }
            case (4):{
                System.out.println("x = 4\t(x = " + x + ")");
                break;
            }
            //вып если не найдены подходящие значения в case
            default:{
                System.out.println("Unexpected value\t(x = " + x + ")");
            }
        }
    }
}
