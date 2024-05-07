package com.ask.workout.algo.leetcode3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/description/
 */
public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<List<Integer>> result1 = permutations.permute(new int[]{1,2,3});

    }
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        permutation(nums, new ArrayList<>());
        return result;
    }

    public void permutation(int[] nums, List<Integer> tempList) {
      if (tempList.size() == nums.length) {
          result.add(new ArrayList<>(tempList));
          return;
      }
        for (int index = 0; index < nums.length; index++) {
            if (tempList.contains(nums[index])) continue;
            tempList.add(nums[index]);
            permutation(nums, tempList);
            tempList.remove(tempList.size()-1);
        }

    }

}
