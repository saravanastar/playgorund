package com.ask.workout.algo.leetcode3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
//        threeSum.print(threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}));
        threeSum.print(threeSum.threeSum(new int[]{0,0,0,0}));
    }

    private void print(List<List<Integer>> lists) {
        lists.stream().forEach(collection -> collection.stream().forEach(data -> System.out.print(data + "\t")));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int currentIndex = 0;
        int n = nums.length;
        List<List<Integer>> result = new ArrayList();
        while(currentIndex < n-2) {

            while (currentIndex < n-2 && currentIndex > 0 && nums[currentIndex-1] == nums[currentIndex]) {
                currentIndex++;
                continue;
            }
            int j = currentIndex + 1;
            int k = n-1;
            while (j < k) {
                int sum = nums[currentIndex] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> subResult = new ArrayList();
                    subResult.add(nums[currentIndex]);
                    subResult.add(nums[j]);
                    subResult.add(nums[k]);
                    result.add(subResult);
                    while (j < k && nums[j + 1] == nums[j]) {
                        j++;
                    }
                    while (j < k && nums[k - 1] == nums[k]) {
                        k--;
                    }
                    j++;
                    k--;


                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
            currentIndex++;

        }

        return result;
    }
}
