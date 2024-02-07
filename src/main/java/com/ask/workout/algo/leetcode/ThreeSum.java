package com.ask.workout.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

    /**
     * [-1,0,1,2,-1,-4]
     * -4 -1 -1 0 1 2
     *  i  L        R
     */



    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] input1 = {-2,0,1,1,2};
        threeSum.threeSum(input1).stream().flatMap(List::stream).forEach(System.out::println);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i >0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = nums.length -1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum ==0) {
                    result.add(List.of(nums[i] , nums[left] , nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right+1]) {
                        right--;
                    }
                }else if (sum < 0) {
                    left ++;
                } else {
                    right--;
                }

            }
        }

        return result;
    }
}
