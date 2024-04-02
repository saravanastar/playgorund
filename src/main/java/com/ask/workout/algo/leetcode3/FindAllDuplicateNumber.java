package com.ask.workout.algo.leetcode3;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 */
public class FindAllDuplicateNumber {
    public static void main(String[] args) {
        FindAllDuplicateNumber number = new FindAllDuplicateNumber();
        int[] input = {4,3,2,7,8,2,3,1};
        System.out.println(number.findDuplicates(input));

        int[] input1 = {1};
        System.out.println(number.findDuplicates(input1));
    }

    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> result = new HashSet<>();
        int currentIndex = 0;
        while (currentIndex < nums.length) {

            while (nums[currentIndex] != nums[nums[currentIndex] - 1] ) {
                if (nums[currentIndex] == nums[nums[currentIndex] - 1]) {
                    result.add(nums[currentIndex]);
                    break;
                }
                swap(nums, currentIndex, nums[currentIndex] - 1);
            }
            currentIndex++;
        }
        return  new ArrayList<>(result);
    }

    public void swap(int[] input, int source, int destination) {
        int temp = input[source];
        input[source] = input[destination];
        input[destination] = temp;
    }
}
