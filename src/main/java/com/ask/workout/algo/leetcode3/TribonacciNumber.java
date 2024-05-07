package com.ask.workout.algo.leetcode3;

import java.util.HashMap;
import java.util.Map;


/**
 * https://leetcode.com/problems/n-th-tribonacci-number/
 */
public class TribonacciNumber {

    public static void main(String[] args) {
        TribonacciNumber tribonacciNumber = new TribonacciNumber();
        System.out.println(tribonacciNumber.tribonacci(4));
        System.out.println(tribonacciNumber.tribonacci(25));
    }
    Map<Integer, Integer> lookup = new HashMap<>();
    public int tribonacci(int n) {
        if ( n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        if (lookup.containsKey(n)) {
            return lookup.get(n);
        }
        int result = tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
        lookup.put(n, result);
        return result;

    }
}
