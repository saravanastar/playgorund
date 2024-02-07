package com.ask.workout.algo.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/description/
 */
public class SortColors {
    public static void main(String[] args) {
        int[] input1 = new int[]{2,0,1};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(input1);
        Arrays.stream(input1).forEach(System.out::println);
    }

    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;

        while (cur <= right) {
            if (nums[cur] == 2) {
                swap(nums, cur, right);
                right--;
            } else if (nums[cur] == 1) {
                cur++;
            } else {
                swap(nums, cur, left);
                cur++;
                left++;
            }
        }
    }

    private void swap(int[] nums, int from, int to) {
        int temp  = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
