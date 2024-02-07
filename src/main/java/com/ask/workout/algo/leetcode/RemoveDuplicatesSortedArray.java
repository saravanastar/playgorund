package com.ask.workout.algo.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesSortedArray {

    public static void main(String[] args) {
//        System.out.println(new RemoveDuplicatesSortedArray().removeDuplicates(new int[] {1,1,2}));
        System.out.println(new RemoveDuplicatesSortedArray().removeDuplicates(new int[] {1,2}));
//        System.out.println(new RemoveDuplicatesSortedArray().removeDuplicates(new int[] {1,1,1}));
//        System.out.println(new RemoveDuplicatesSortedArray().removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
//        System.out.println(new RemoveDuplicatesSortedArray().removeDuplicates(new int[] {0,0,0,1,1,2,2,3,3,4}));
    }
    public int removeDuplicates(int[] nums)  {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
//    public int removeDuplicates(int[] nums) {
//        int result = nums.length;
//        int size = nums.length;
//        if (size < 2) return size;
//        int left = 0;
//        int right = 1;
//        while(right < size) {
//            if (nums[left] > nums[right]) return result;
//            if (nums[left] == nums[right]) {
//                int temp = right;
//                while (right < size && nums[left] == nums[right]) {
//                    right++;
//                }
//                int diff = (right-temp);
//                result = result - diff;
//                for (int index = right; index < size; index++) {
//                    nums[temp] = nums[index];
//                    temp++;
//                }
//                left++;
//                right = left +1;
//                size = size-diff;
//            } else {
//                left++;
//                right = left +1;
//            }
//        }
//        return result;
//    }
}
