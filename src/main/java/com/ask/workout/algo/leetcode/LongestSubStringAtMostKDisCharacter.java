package com.ask.workout.algo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringAtMostKDisCharacter {
    public static void main(String[] args) {
        LongestSubStringAtMostKDisCharacter longestSubStringAtMostKDisCharacter = new LongestSubStringAtMostKDisCharacter();
        System.out.println(longestSubStringAtMostKDisCharacter.longestSubstringAtMostKDistinct("eceba", 2));
        System.out.println(longestSubStringAtMostKDisCharacter.longestSubstringAtMostKDistinct("ccaabbb", 3));
        System.out.println(longestSubStringAtMostKDisCharacter.longestSubstringAtMostKDistinct("ccaabbb", 2));
    }
    public int longestSubstringAtMostKDistinct(String input, int k) {
        char[] inputArray = input.toCharArray();
        Map<Character, Integer> lookup = new HashMap<>();
        int left =0, right =0;
        int result = Integer.MIN_VALUE;
        while (right < inputArray.length) {
            lookup.computeIfPresent(inputArray[right], (key, val) -> val +1);
            lookup.computeIfAbsent(inputArray[right], (key) -> 1);
            if (lookup.size() == k) {
                while (right + 1 < inputArray.length && lookup.containsKey(inputArray[right+1])) {
                    lookup.computeIfPresent(inputArray[right+1], (key, val) -> val +1);
                    right++;
                }
                result = Math.max(result, (right-left) +1 );

                lookup.computeIfPresent(inputArray[left], (key, val) -> val - 1);
                if (lookup.get(inputArray[left]) == 0) {
                    lookup.remove(inputArray[left]);
                }
                left++;
                right++;
            } else if (lookup.size() < k) {
                right++;
            } else {
                lookup.computeIfPresent(inputArray[left], (key, val) -> val - 1);
                if (lookup.get(inputArray[left]) == 0) {
                    lookup.remove(inputArray[left]);
                }
                left++;
                right++;
            }
        }
        return result;
    }
}
