package com.ask.workout.algo.sorting;

import java.util.Arrays;

/**
 * https://www.programiz.com/dsa/merge-sort
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] input = {1,5, 10, 12, 6, 9};
        int left = 0;
        int right = input.length -1;
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input, left, right);
        Arrays.stream(input).forEach(System.out::println);
    }

    public void mergeSort(int[] input, int left, int right) {
        // perform only if left < right
        if (left < right) {
            // find the middle
            int middle = (left + right) / 2;
            //perform the sort for left subset
            mergeSort(input, left, middle);
            //perform the sort for right subset
            mergeSort(input, middle + 1, right);
            // sort it
            merge(input, left, middle, right);
        }
    }

    public void merge(int[] input, int left, int middle, int right) {
        int array1Len = middle - left + 1;
        int array2Len = right - middle;
        // create 2 separate arrays, left -> middle and middle +1 -> right
        int[] array1 = new int[array1Len];
        int[] array2 = new int[array2Len];

        // copy the values left -> middle to array1
        for (int index = 0; index < array1Len; index++) {
            array1[index] = input[index + left];
        }

        // copy the values middle +1  -> right to array2
        for (int index = 0; index < array2Len; index++) {
            array2[index] = input[index + middle + 1];
        }

        int array1Index = 0;
        int array2Index = 0;
        int inputArrayIndex = left;
        // compare the array1 and array2 and copy the lowest values to input array
        while (array1Index < array1Len && array2Index < array2Len) {
            if (array1[array1Index] <= array2[array2Index]) {
                input[inputArrayIndex] = array1[array1Index];
                array1Index++;
            } else {
                input[inputArrayIndex] = array2[array2Index];
                array2Index++;
            }
            inputArrayIndex++;
        }


        // copy the remaining values from array1 to input
        while (array1Index < array1Len) {
            input[inputArrayIndex] = array1[array1Index];
            inputArrayIndex++;
            array1Index++;
        }

        // copy the remaining values from array2 to input
        while (array2Index < array2Len) {
            input[inputArrayIndex] = array2[array2Index];
            inputArrayIndex++;
            array2Index++;
        }
    }
}
