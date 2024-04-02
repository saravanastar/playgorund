package com.ask.workout.algo.leetcode3;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/description/
 */
public class MaximumValueOfKCoin {

    public static void main(String[] args) {
       int[][] input = {{1,100,3},{7,8,9}};
       int[][] input2 = {{37,88},{51,64,65,20,95,30,26},{9,62,20},{44}};

        MaximumValueOfKCoin maximumValueOfKCoin = new MaximumValueOfKCoin();
//        System.out.println(maximumValueOfKCoin.maxValueOfCoins(convertToList(input), 2));
        int result = maximumValueOfKCoin.maxValueOfCoins(convertToList(input2), 9);
        System.out.println(result);

    }

    private static List<List<Integer>> convertToList(int[][] input) {
        List<List<Integer>> request = new ArrayList<>();
        for (int[] val :
                input) {
            List<Integer> temp = Arrays.stream(val).mapToObj(Integer::valueOf).collect(Collectors.toList());
            request.add(temp);
        }
        return request;
    }

    Map<String, Integer> lookup;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        lookup = new HashMap<>();
        return maxCoins(piles, k, 0, 0, 0);
    }

    public int maxCoins(List<List<Integer>> piles, int currentLeftCoins, int rowIndex, int columnIndex, int currentSum) {
        if (currentLeftCoins == 0) {
            return currentSum;
        }
        if (rowIndex >= piles.size()  || columnIndex >= piles.get(rowIndex).size() ) {
            return 0;
        }
//        if (this.contains(rowIndex, columnIndex)) {
//            return this.get(rowIndex, columnIndex);
//        }
        int val = piles.get(rowIndex).get(columnIndex);

        int result = Math.max(maxCoins(piles, currentLeftCoins - 1, rowIndex, columnIndex + 1, currentSum + val)
        , maxCoins(piles, currentLeftCoins, rowIndex+1, 0, currentSum));
        this.put(rowIndex, columnIndex, result);
        return result;
    }

    private void put(int rowIndex, int column, int currentSum) {
        String key = getKey(rowIndex, column);
        lookup.put(key, currentSum);
    }

    private boolean contains(int rowIndex, int column) {
        String key = getKey(rowIndex, column);
        return lookup.containsKey(key);
    }

    private int get(int rowIndex, int column) {
        String key = getKey(rowIndex, column);
        return lookup.get(key);
    }


    private static String getKey(int rowIndex, int column) {
        return rowIndex + ":" + column;

    }
}
