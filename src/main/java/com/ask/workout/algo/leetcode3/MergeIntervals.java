package com.ask.workout.algo.leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] input1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] input2 = {{1, 4}, {4, 5}};
        int[][] input3 = {{1, 4}, {0, 4}};

        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] result = mergeIntervals.merge(input3);
        Arrays.stream(result).forEach(array -> Arrays.stream(array).forEach(value -> System.out.print(value + "\t")));
    }

    public int[][] merge(int[][] intervals) {

        int row = intervals.length;
        if (row == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (interval1, interval2) -> {
            return Integer.compare(interval1[0], interval2[0]);
        });
        List<List<Integer>> result = new ArrayList<>();
        int minStarts = intervals[0][0];
        int maxEnds = intervals[0][1];
        int currentRow = 1;

        while (currentRow < intervals.length) {
            boolean isOverlapping = isOverlapping(intervals, currentRow, minStarts, maxEnds);
            if (isOverlapping) {
                while (isOverlapping) {
                    minStarts = Math.min(minStarts, intervals[currentRow][0]);
                    maxEnds = Math.max(maxEnds, intervals[currentRow][1]);
                    currentRow++;
                    isOverlapping = isOverlapping(intervals, currentRow, minStarts, maxEnds);
                }
            } else {
                List<Integer> subResult = new ArrayList<>();
                subResult.add(minStarts);
                subResult.add(maxEnds);
                result.add(subResult);
                minStarts = intervals[currentRow][0];
                maxEnds = intervals[currentRow][1];
                currentRow++;
            }
        }
        List<Integer> subResult = new ArrayList<>();
        subResult.add(minStarts);
        subResult.add(maxEnds);
        result.add(subResult);
        int[][] resultArray = new int[result.size()][2];
        for (int index = 0; index < result.size(); index++) {
            resultArray[index][0] = result.get(index).get(0);
            resultArray[index][1] = result.get(index).get(1);

        }
        return resultArray;

    }


    private boolean isOverlapping(int[][] intervals, int row, int minStart, int maxEnd) {
        return row < intervals.length && ((intervals[row][0] >= minStart && intervals[row][0] <= maxEnd)
                || (intervals[row][0] <= minStart && minStart <= intervals[row][1]));
    }
}
