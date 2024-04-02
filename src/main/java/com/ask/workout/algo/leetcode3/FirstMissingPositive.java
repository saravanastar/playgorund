package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/first-missing-positive/description/
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] input = {7, 8, 9, 11, 12};
        FirstMissingPositive missingPositive = new FirstMissingPositive();
        System.out.println(missingPositive.firstMissingPositive(input));
        System.out.println(missingPositive.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(missingPositive.firstMissingPositive(new int[]{1, 1}));
    }

    public int firstMissingPositive(int[] nums) {
        int currentIndex = 0;

        while (currentIndex < nums.length) {

            while (nums[currentIndex] > 0 && nums[currentIndex] <= nums.length && nums[currentIndex] != currentIndex + 1) {
                if (nums[currentIndex] == nums[nums[currentIndex] - 1]) {
                    break;
                }
                swap(nums, currentIndex, nums[currentIndex] - 1);
            }
            currentIndex++;
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
        }
        return nums.length + 1;
    }

    public void swap(int[] input, int source, int destination) {
        int temp = input[source];
        input[source] = input[destination];
        input[destination] = temp;
    }
}
