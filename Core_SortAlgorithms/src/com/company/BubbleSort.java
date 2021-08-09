package com.company;

//сортировка пузырьком
//https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%BF%D1%83%D0%B7%D1%8B%D1%80%D1%8C%D0%BA%D0%BE%D0%BC
public class BubbleSort {
    public static void sort(int[] inputArray){
        for(int i = 0; i < inputArray.length - 1; i++){
            for(int j = i + 1; j < inputArray.length; j++){
                int temp = inputArray[i];
                if(inputArray[i] > inputArray[j]){
                    inputArray[i] = inputArray[j];
                    inputArray[j] = temp;
                }
            }
        }
    }
}
