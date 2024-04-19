package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element
 */
public class LongestSubArrayAftterDeleting1Element {

    public static void main(String[] args) {
        LongestSubArrayAftterDeleting1Element longestSubArrayAftterDeleting1Element = new LongestSubArrayAftterDeleting1Element();
        System.out.println(longestSubArrayAftterDeleting1Element.longestSubarray(new int[]{1,1,0,1}));
        System.out.println(longestSubArrayAftterDeleting1Element.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
    }

    public int longestSubarray(int[] nums) {
        int leftIndex = 0;
        int rightIndex = 0;
        int max = 0;
        int currentZeros = 0;
        int totalZeros = 0;
        while(rightIndex < nums.length) {
            if (nums[rightIndex] == 0) {
                currentZeros++;
                totalZeros++;
            }
            while (leftIndex < rightIndex && currentZeros > 1) {
                int val = nums[leftIndex];
                if (val == 0) {
                    currentZeros--;
                }
                leftIndex++;
            }
            if (currentZeros == 1) {
                max = Math.max(max, (rightIndex - leftIndex));
            }
            rightIndex++;

        }
        if (totalZeros ==0) {
            return nums.length-1;
        }

        return max;

    }
}
