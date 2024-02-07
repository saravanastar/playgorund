package com.ask.workout.algo.leetcode;

import java.util.Arrays;

public class ThreeSumSmaller {
    public static void main(String[] args) {

    }

    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) return 0;

        Arrays.sort(nums);
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int left = i +1;
            int right = nums.length -1;
            while (left < right) {
                int curSum = nums[i] + nums[left] + nums[right];
                if (curSum <= target) {
                    counter+=(right-left);
                    left++;
                } else  {
                    right--;
                }
            }
        }
        return counter;
    }


}
