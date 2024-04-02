package com.ask.workout.algo.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] input = {5,4,3,2,1};
        Arrays.stream(sort.doBubbleSort(input)).forEach(number -> System.out.print(number + "\t"));
    }
    
    public int[] doBubbleSort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length-i-1; j++) {
                if (input[j] > input[j+1]) {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
        return input;
    }
}
