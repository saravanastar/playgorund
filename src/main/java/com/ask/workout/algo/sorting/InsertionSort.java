package com.ask.workout.algo.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        int[] input = {5,4,3,2,1};
        Arrays.stream(sort.doInsertionSort(input)).forEach(number -> System.out.print(number + "\t"));
    }

    public int[] doInsertionSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i-1;
            while (j>=0 && nums[j] > key) {
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
                j = j-1;
            }
        }
        return nums;
    }
}
