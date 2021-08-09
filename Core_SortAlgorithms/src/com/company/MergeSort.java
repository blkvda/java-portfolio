package com.company;

import java.util.Arrays;

public class MergeSort {
    public static int[] sort(int[] inputArray){
        if(inputArray.length <= 1){
            return inputArray;
        }
        else{
            int[] left = Arrays.copyOfRange(inputArray, 0, inputArray.length/2);
            int[] right = Arrays.copyOfRange(inputArray, inputArray.length/2, inputArray.length);
            return merge(sort(left),sort(right));
        }
    }
    private static int[] merge(int[] left, int[] right){
        System.out.println("Left: " + Arrays.toString(left));
        System.out.println("Right: " + Arrays.toString(right));
        int[] result = new int[left.length + right.length];
        int indexRight = 0;
        int indexLeft = 0;

        for(int i = 0; i < result.length; i++){
            if(indexLeft >= left.length){
                result[i] = right[indexRight];
                indexRight++;
                continue;
            }
            if(indexRight >= right.length){
                result[i] = left[indexLeft];
                indexLeft++;
                continue;
            }
            if(left[indexLeft] < right[indexRight]){
                result[i] = left[indexLeft];
                indexLeft++;
            }
            else{
                result[i] = right[indexRight];
                indexRight++;
            }
        }
        return result;
    }
}
