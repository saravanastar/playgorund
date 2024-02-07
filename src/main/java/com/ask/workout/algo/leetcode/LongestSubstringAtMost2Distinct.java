package com.ask.workout.algo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringAtMost2Distinct {

    public static void main(String[] args) {
        LongestSubstringAtMost2Distinct longestSubstringAtMost2Distinct = new LongestSubstringAtMost2Distinct();
        System.out.println(longestSubstringAtMost2Distinct.longestSubstringAtMost2Distinct("eceba"));
        System.out.println(longestSubstringAtMost2Distinct.longestSubstringAtMost2Distinct("ccaabbb"));
    }

    public int longestSubstringAtMost2Distinct(String s) {
        int result = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        char[] inputArray = s.toCharArray();
        Map<Character, Integer> lookup = new HashMap<>();
        while (right < inputArray.length) {
            lookup.computeIfPresent(inputArray[right], (key, val) -> val + 1);
            lookup.computeIfAbsent(inputArray[right], key -> 1);
            if (lookup.size() == 2) {
                while (right + 1 < inputArray.length && lookup.containsKey(inputArray[right+1])) {
                    right++;
                    lookup.computeIfPresent(inputArray[right], (key, val) -> val + 1);
                }
                result = Math.max((right - left) + 1, result);
                if (lookup.get(inputArray[left]) == 1) {
                    lookup.remove(inputArray[left]);
                }
                lookup.computeIfPresent(inputArray[left], (key, val) -> val - 1);
                left++;
                right++;
            } else if (lookup.size() < 2) {
                right++;
            } else {
                if (lookup.get(inputArray[left]) == 1) {
                    lookup.remove(inputArray[left]);
                }
                lookup.computeIfPresent(inputArray[left], (key, val) -> val - 1);
                left++;
                right++;
            }

        }

        return result;

    }
}
