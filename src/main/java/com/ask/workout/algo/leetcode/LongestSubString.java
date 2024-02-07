package com.ask.workout.algo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubString {

    public static void main(String[] args) {
//        System.out.println(new LongestSubString().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubString().lengthOfLongestSubstring("bbbbb"));
//        System.out.println(new LongestSubString().lengthOfLongestSubstring("pwwkew"));
//        System.out.println(new LongestSubString().lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {

        char[] input = s.toCharArray();
        int length = input.length;

        if (length < 2) return length;

        int result = 1;
        int left = 0;
        int right = 0;
        final Map<Character, Integer> lookup = new HashMap<>();
        while(right < length) {
            lookup.put(input[right], lookup.getOrDefault(input[right], 0) + 1);
            while (lookup.size() != right-left + 1) {
                lookup.put(input[left], lookup.get(input[left]) - 1);
                if (lookup.get(input[left]) == 0) {
                    lookup.remove(input[left]);
                }
                left++;
            }
            result = Math.max(result, right-left + 1);
            right++;
        }

        return result;
    }

}
