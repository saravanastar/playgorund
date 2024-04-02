package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/missing-number/description/
 */
public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber number = new MissingNumber();
        int[] input = {3,0,1};
        System.out.println(number.missingNumber(input));
    }
    public int missingNumber(int[] nums) {
        int currentIndex = 0;
        while (currentIndex < nums.length) {

            while (nums[currentIndex] < nums.length && currentIndex != nums[currentIndex]) {
                swap(nums, nums[currentIndex], currentIndex);
            }
            currentIndex++;
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index) {
                return index;
            }
        }
        return nums.length;
    }

    public void swap(int[] input, int source, int destination) {
        int temp = input[source];
        input[source] = input[destination];
        input[destination] = temp;
    }
}
