package com.ask.workout.algo.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeros {

    public static void main(String[] args) {
        int[] input1 = {0,1,0,3,12};
        int[] input2 = {0};
        new MoveZeros().moveZeroes(input1);
        Arrays.stream(input1).forEach(System.out::println);
    }
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right =0;
        while (right <  nums.length) {
            right = left;
            if (nums[left] == 0) {
                while (right < nums.length && nums[right] == 0) {
                    right++;
                }
                if (right >= nums.length) {
                    break;
                }
                swap(left,right, nums);
                left++;
                right = left;
            } else {
                left++;
                right++;
            }

        }
    }

    private void swap(int left, int right, int[] nums) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
}
