package com.ask.workout.algo.leetcode;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumSortedArray {

    public static void main(String[] args) {
        FindMinimumSortedArray findMinimumSortedArray = new FindMinimumSortedArray();
        System.out.println(findMinimumSortedArray.findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMinimumSortedArray.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMinimumSortedArray.findMin(new int[]{11,13,15,17}));
    }

    /**
     * Linear Solution: O(n)
     * @param nums
     * @return
     */
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

    /**
     * O(log n)
     * @param nums
     * @return
     */
    public int findMinLogn(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        if (nums[left] < nums[right]) return nums[left];


        while (left +1 < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }

    /**
     * 2, 3, 4, 5, 6, 7, 0, 1, 2
     *
     * left = 0, right =8;
     * 0 8/2 = 4
     *
     * left = 4 right = 8
     *
     */
}
