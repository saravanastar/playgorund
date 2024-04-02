package com.ask.workout.algo.leetcode3;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 */
public class FindAllNumbersDisappeared {

    public static void main(String[] args) {
        FindAllNumbersDisappeared findAllNumbersDisappeared = new FindAllNumbersDisappeared();
        int[] input = {4,3,2,7,8,2,3,1};
        System.out.println(findAllNumbersDisappeared.findDisappearedNumbers(input));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int currentIndex = 0;
        while (currentIndex < nums.length) {

            while (nums[currentIndex] <= nums.length && currentIndex+1 != nums[currentIndex]) {
                if (nums[currentIndex] == nums[nums[currentIndex]-1]) {

                    break;
                }
                swap(nums, nums[currentIndex]-1, currentIndex);
            }
            currentIndex++;
        }
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index]-1 != index) {
                result.add(index +1) ;
            }
        }
        return result;
    }

    public void swap(int[] input, int source, int destination) {
        int temp = input[source];
        input[source] = input[destination];
        input[destination] = temp;
    }
}
