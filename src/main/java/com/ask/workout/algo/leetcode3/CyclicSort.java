package com.ask.workout.algo.leetcode3;

import java.util.Arrays;

public class CyclicSort {

    public static void main(String[] args) {
        CyclicSort sort = new CyclicSort();
        int[] input = new int[]{5,4,3,2,1};
        sort.cyclicSort(input);
        Arrays.stream(input).forEach(number -> System.out.print(number + "\t"));
    }

    public void cyclicSort(int[] nums) {

        int currentIndex = 0;
        while(currentIndex < nums.length) {
            while (nums[currentIndex]-1 != currentIndex) {
                swap(nums, nums[currentIndex]-1, currentIndex);
            }
            currentIndex++;
        }
    }

    public void swap(int[] input, int source, int destination) {
        int temp = input[source];
        input[source] = input[destination];
        input[destination] = temp;
    }
}
