package com.ask.workout.algo.leetcode3;

import java.util.*;

public class SetMismatch {

    public static void main(String[] args) {
        SetMismatch setMismatch = new SetMismatch();
        int[] input = {1,2,2,4};
        Arrays.stream(setMismatch.findErrorNums(input)).forEach(number -> System.out.print(number + "\t"));
        Arrays.stream(setMismatch.findErrorNums(new int[]{1,1})).forEach(number -> System.out.print(number + "\t"));
    }

    public int[] findErrorNums(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int currentIndex = 0;
        while (currentIndex < nums.length) {

            while (nums[currentIndex] != nums[nums[currentIndex] - 1] ) {
                if (nums[currentIndex] == nums[nums[currentIndex] - 1]) {
                    break;
                }
                swap(nums, currentIndex, nums[currentIndex] - 1);
            }
            currentIndex++;
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                result.add(index+1);
                result.add(nums[index]);
            }
        }
        return  result.stream().mapToInt(num -> num).toArray();
    }

    public void swap(int[] input, int source, int destination) {
        int temp = input[source];
        input[source] = input[destination];
        input[destination] = temp;
    }
}
