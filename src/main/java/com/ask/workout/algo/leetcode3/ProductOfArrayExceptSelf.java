package com.ask.workout.algo.leetcode3;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] input1 = {1,2,3,4};
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        print(productOfArrayExceptSelf.productExceptSelf2(input1));
        print(productOfArrayExceptSelf.productExceptSelf2(new int[]{-1,1,0,-3,3}));
    }

    private static void print(int[] result) {
        Arrays.stream(result).forEach(num -> System.out.print(num + "\t"));
        System.out.println();
    }

    public int[] productExceptSelf(int[] nums) {
        int totalProduct = Arrays.stream(nums).filter(num -> num != 0).reduce(1, (a, b) -> a * b);
        int[]  result  = new int[nums.length];
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] !=0) {
                result[index] = totalProduct / nums[index];
            } else {
                result[index] = totalProduct;
            }
        }
        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
       int[] leftProduct = new int[nums.length];
       leftProduct[0] = 1;
        for (int index = 1; index < nums.length; index++) {
            leftProduct[index] = leftProduct[index-1] * nums[index-1];
        }
        int rightProduct = 1;
        int prevNum = 0;
        for (int index = nums.length-1; index >= 0; index--) {
            prevNum = nums[index];
            nums[index] = rightProduct * leftProduct[index];
            rightProduct = prevNum * rightProduct;
        }
        return nums;
    }
}
