package com.ask.workout.algo.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        int[] input = {5,4,3,2,1};
        Arrays.stream(sort.doSelectionSort(input)).forEach(number -> System.out.print(number + "\t"));
    }


    public int[] doSelectionSort(int[] input) {

        for (int i = 0; i < input.length; i++) {
            int min = i;
            for (int j = i+1; j < input.length; j++) {
                if (input[j] < input[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = input[min];
                input[min] = input[i];
                input[i] = temp;
            }
        }
        return input;
    }
}
