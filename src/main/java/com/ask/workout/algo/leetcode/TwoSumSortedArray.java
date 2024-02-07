package com.ask.workout.algo.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumSortedArray {
    public static void main(String[] args) {
        Arrays.stream(new TwoSumSortedArray().twoSum(new int[]{2,7,11,15}, 9)).forEach(System.out::println);
    }
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) return new int[]{};
        int left = 0, right = numbers.length-1;
        while(left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[] {left +1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{};

    }
}
