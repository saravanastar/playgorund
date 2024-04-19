package com.ask.workout.algo.leetcode3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * https://leetcode.com/problems/equal-row-and-column-pairs
 */
public class EqualRowColumnPairs {


    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> lookup = new HashMap<>();

        for (int row = 0; row < grid.length; row++) {
            List<Integer> rowVal = new ArrayList<>();
            for (int column = 0; column < grid[0].length; column++) {
                rowVal.add(grid[row][column]);
            }
            lookup.computeIfPresent(rowVal, (key,val) -> val + 1);
            lookup.putIfAbsent(rowVal, 1);
        }


        int result = 0;
        for (int column = 0; column < grid[0].length; column++) {
            List<Integer> rowVal = new ArrayList<>();
            for (int row = 0; row < grid.length; row++) {
                rowVal.add(grid[row][column]);
            }
            int count = lookup.getOrDefault(rowVal, 0);
            result += count;

        }
        return result;
    }
}
