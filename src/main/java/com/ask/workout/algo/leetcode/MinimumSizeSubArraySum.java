package com.ask.workout.algo.leetcode;

/**
 * <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">...</a>
 */
public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubArraySum().minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int wSum = 0;
        while (right < nums.length) {
            wSum = wSum + nums[right];
            while (wSum >= target) {
                result = Math.min(result, right-left + 1);
                wSum-= nums[left];
                left++;
            }
            if (wSum >= target) {
                result = Math.min(result, right - left + 1);
            }
            right++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;

    }
}
