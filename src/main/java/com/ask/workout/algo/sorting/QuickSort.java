package com.ask.workout.algo.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] input = {4,5,6,1,3};
       sort.quickSort(input, 0, input.length-1);
        Arrays.stream(input).forEach(System.out::println);
    }

    public void quickSort(int[] input, int low, int high) {
        if (low < high) {
            int partition = partition(input, low, high);
            quickSort(input, low, partition-1);
            quickSort(input, partition, high);
        }
    }
    public int partition(int[] input, int low, int high) {
        int pivotIndex = (low + high)/2;
        int pivot = input[pivotIndex];
        while (low <= high) {
            while (input[low] < pivot) {
                low++;
            }
            while ( input[high] > pivot) {
                high--;
            }
            if (low <= high) {
                swap(input, low, high);
                low++;
                high--;
            }
        }

        return low;
    }

    private void swap(int[] input, int low, int high) {
        int temp = input[low];
        input[low] = input[high];
        input[high] = temp;
    }
}
