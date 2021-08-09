package com.company;


//https://neerc.ifmo.ru/wiki/index.php?title=%D0%91%D1%8B%D1%81%D1%82%D1%80%D0%B0%D1%8F_%D1%81%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0
public class QuickSort {
    public static void sort(int[] inputArray, int beginIndex, int endIndex){
        if(beginIndex < endIndex){
            int mediumIndex = divideArray(inputArray, beginIndex, endIndex);
            sort(inputArray, beginIndex, mediumIndex);
            sort(inputArray, mediumIndex + 1, endIndex);
        }
    }

    private static int divideArray(int[] inputArray, int beginIndex, int endIndex){
        int medium = inputArray[(beginIndex + endIndex) / 2];
        while(beginIndex <= endIndex){
            while (inputArray[beginIndex] < medium){
                beginIndex++;
            }
            while (inputArray[endIndex] > medium){
                endIndex--;
            }
            if(beginIndex >= endIndex){
                break;
            }
            swap(inputArray, beginIndex++, endIndex--);
        }
        return endIndex;
    }

    private static void swap(int[] inputArray, int firstIndex, int secondIndex){
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;
    }
}
