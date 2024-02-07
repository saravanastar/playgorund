package com.ask.workout.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/partition-labels/
 */
public class PartitionLabels {
    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels("ababcbacadefegdehijhklij"));

    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        char[] inputArray = s.toCharArray();
        int[] cache = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char cur = inputArray[i];
            cache[cur] = i;
        }

        int left = 0;
        int right = 0;

        int index = 0;
        while (index < s.length()) {
            char cur = inputArray[index];
            right = Math.max(cache[cur], right);
            if (right == index) {
                result.add(right - left + 1);
                right++;
                left = right;
            }
            index++;
        }

        return result;

    }

}
