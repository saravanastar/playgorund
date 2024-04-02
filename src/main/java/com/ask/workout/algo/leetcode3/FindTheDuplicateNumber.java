package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 */
public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        int[] input = {1,3,4,2,2};
        FindTheDuplicateNumber number = new FindTheDuplicateNumber();
        System.out.println(number.findDuplicate(input));
    }

    public int findDuplicate(int[] nums) {
            int currentIndex = 0;
            while (currentIndex < nums.length) {

                while (nums[currentIndex] != currentIndex + 1) {
                    if (nums[currentIndex] == nums[nums[currentIndex] - 1]) {
                        return nums[currentIndex];
                    }
                    swap(nums, currentIndex, nums[currentIndex] - 1);
                }
                currentIndex++;
            }
            return  0;
        }

        public void swap(int[] input, int source, int destination) {
            int temp = input[source];
            input[source] = input[destination];
            input[destination] = temp;
        }
}
