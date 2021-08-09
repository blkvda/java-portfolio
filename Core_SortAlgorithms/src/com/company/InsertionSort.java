package com.company;

//сортировка вставкой
//https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%B2%D1%81%D1%82%D0%B0%D0%B2%D0%BA%D0%B0%D0%BC%D0%B8
public class InsertionSort {
    public static void sort(int[] inputArray){
        for(int i = 0; i < inputArray.length; i++){
            int largerValuePos = findLargerValue(inputArray, i);
            if(largerValuePos != -1){
                shiftArray(inputArray, i, largerValuePos);
            }
        }
    }
    private static int findLargerValue(int[] inputArray, int currentValuePos){
        for(int i = 0; i < currentValuePos; i++){
            if(inputArray[currentValuePos] < inputArray[i]){
                return i;
            }
        }
        return -1;
    }
    private static void shiftArray(int[] inputArray, int currentValuePos, int largerValuePos){
        int temp = inputArray[currentValuePos];
        for(int i = currentValuePos; i > largerValuePos; i--){
            inputArray[i] = inputArray[i - 1];
        }
        inputArray[largerValuePos] = temp;
    }
}
