package com.ask.workout.algo.leetcode3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/description
 */
public class FindDifferentTwoArrays {


    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num1 : nums1) {
            set1.add(num1);
        }

        for (int num2: nums2) {
            if (!set1.contains(num2)) {
                set2.add(num2);
            }
            set1.remove(num2);
        }
        for (int num1 : nums1) {
            set2.remove(num1);
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(set1));
        result.add(new ArrayList<>(set2));
        return result;
    }
}
