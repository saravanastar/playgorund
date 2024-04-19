package com.ask.workout.algo.leetcode3;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/description
 */
public class MaxNumberKSumPairs {

    public static void main(String[] args) {
        MaxNumberKSumPairs maxNumberKSumPairs = new MaxNumberKSumPairs();
        System.out.println(maxNumberKSumPairs.maxOperations(new int[]{1,2,3,4}, 5));
        System.out.println(maxNumberKSumPairs.maxOperations(new int[]{3,1,3,4,3}, 6));
    }
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> lookup = new HashMap<>();
        int count = 0;

        for (int index = 0; index < nums.length; index++) {
            int remaining = k - nums[index];
            Integer fromLookup = lookup.get(remaining);
            if (fromLookup != null) {
                count+=1;
                if (fromLookup == 1) {
                    lookup.remove(remaining);
                } else {
                    lookup.put(remaining, fromLookup-1);
                }
            } else {
                lookup.computeIfPresent(nums[index], (key, value) -> value + 1);
                lookup.computeIfAbsent(nums[index], (key) ->  1);
            }
            
        }
        return count;

    }

}
