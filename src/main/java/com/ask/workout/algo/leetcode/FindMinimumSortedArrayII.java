package com.ask.workout.algo.leetcode;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinimumSortedArrayII {

    public static void main(String[] args) {
        FindMinimumSortedArrayII findMinimumSortedArray = new FindMinimumSortedArrayII();
        System.out.println(findMinimumSortedArray.findMin(new int[]{1,3,5}));
        System.out.println(findMinimumSortedArray.findMin(new int[]{2,2,2,0,1}));
    }

    public int findMin(int[] nums) {
        if (nums.length ==0) return -1;
        int minVal = nums[0];

        for (int num: nums
             ) {
            if (num < minVal) {
                return num;
            }
        }
        return minVal;
    }
}
