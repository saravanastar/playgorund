package com.ask.workout.algo.leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertIntervals {

    public static void main(String[] args) {
        int[][] interval1 = {{1,3},{6,9}};
        int[][] interval2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval1 = {2, 5};
        int[] newInterval2 = {4, 8};
        InsertIntervals insertIntervals = new InsertIntervals();
        int[][] result = insertIntervals.insert(interval1, newInterval1);
        Arrays.stream(result).forEach(array -> Arrays.stream(array).forEach(value -> System.out.print(value + "\t")));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newArray = new int[intervals.length+1][2];
        for (int index = 0; index < intervals.length; index++) {
            newArray[index][0] = intervals[index][0];
            newArray[index][1] = intervals[index][1];
        }
        newArray[newArray.length-1] = newInterval;
        Arrays.sort(newArray, Comparator.comparingInt(array -> array[0]));
        int currentIndex = 0;
        List<int[]> result = new ArrayList<>();
        int minLeft = newArray[0][0];
        int maxRight = newArray[0][1];
        while (currentIndex < newArray.length) {
            boolean isOverlap = isOverlap(newArray, currentIndex, minLeft, maxRight);
            if (isOverlap) {
                minLeft = Math.min(minLeft, newArray[currentIndex][0]);
                maxRight = Math.max(maxRight, newArray[currentIndex][1]);
            } else {
                result.add(new int[]{minLeft, maxRight});
                minLeft = newArray[currentIndex][0];
                maxRight = newArray[currentIndex][1];
            }
            currentIndex++;
        }
        result.add(new int[]{minLeft, maxRight});
        return result.toArray(new int[result.size()][]);
    }

    private static boolean isOverlap(int[][] intervals, int currentIndex, int minLeft, int maxRight) {
        return currentIndex < intervals.length && (minLeft <= intervals[currentIndex][0] && intervals[currentIndex][0] <= maxRight);
    }

}
