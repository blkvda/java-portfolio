package com.company;

import com.company.BinaryTreeSort.BinaryTreeSort;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] inputArray1 = {43, 44, 12, 32, 1, 0, 11, 11, 12, 33};
        BubbleSort.sort(inputArray1);
        System.out.println("Bubble sort result: " + Arrays.toString(inputArray1));

        int[] inputArray2 = {43, 44, 12, 32, 1, 0, 11, 11, 12, 33};
        InsertionSort.sort(inputArray2);
        System.out.println("Insertion sort result: " + Arrays.toString(inputArray2));

        int[] inputArray3 = {43, 44, 12, 32, 1, 0, 11, 11, 12, 33};
        System.out.print("BinaryTree sort result: ");
        BinaryTreeSort.sort(inputArray3);

        int[] inputArray4 = {43, 44, 12, 32, 1, 0, 11, 11, 12, 33};
        SelectionSort.sort(inputArray4);
        System.out.println("\nSelection sort result: " + Arrays.toString(inputArray4));

        int[] inputArray5 = {43, 44, 12, 32, 1, 0, 11, 11, 12, 33};
        System.out.println("Merge sort result: " + Arrays.toString(MergeSort.sort(inputArray5)));

        int[] inputArray6 = {43, 44, 12, 11, 1, 23, 11, 0};
        QuickSort.sort(inputArray6, 0, inputArray6.length-1);
        System.out.println("Quick sort result: " + Arrays.toString(inputArray6));
    }
}
