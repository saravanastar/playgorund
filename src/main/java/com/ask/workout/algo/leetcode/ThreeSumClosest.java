package com.ask.workout.algo.leetcode;

import com.sun.jdi.IntegerType;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
//        System.out.println(threeSumClosest.threeSumClosest(new int[]{1,1,1,1}, 0));
        System.out.println(threeSumClosest.threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {

        int nItem = nums.length;
        if (nItem < 3) return -1;

        Arrays.sort(nums);
        int closeTargetSum = 0;
        int gap = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nItem -1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int currGap = Math.abs(target - sum);
                if (sum == target) {
                    return target;
                } else if(sum < target) {
                    left++;
                } else {
                    right --;
                }
                if(currGap < gap) {
                    gap = currGap;
                    closeTargetSum = sum;
                }
            }

        }
        return closeTargetSum;

    }
}
