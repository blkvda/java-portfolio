package com.company;

//сортировка выбором
//https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%B2%D1%8B%D0%B1%D0%BE%D1%80%D0%BE%D0%BC
public class SelectionSort {
    public static void sort(int[] inputArray){
        int unsortPos = 0;

        for(int i = 0; i < inputArray.length - 1; i++){
            int minIndex = findMin(inputArray, unsortPos);
            int temp = inputArray[minIndex];
            inputArray[minIndex] = inputArray[unsortPos];
            inputArray[unsortPos] = temp;
            unsortPos++;
        }
    }

    private static int findMin(int[] inputArray, int startIndex){
        int minValue = inputArray[startIndex];
        int minIndex = startIndex;
        for(int i = startIndex + 1; i < inputArray.length; i++){
            if(inputArray[i] < minValue){
                minValue = inputArray[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
