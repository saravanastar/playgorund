package com.ask.workout.algo.leetcode3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubString {

    public static void main(String[] args) {
        LengthOfLongestSubString lengthOfLongestSubString = new LengthOfLongestSubString();
        System.out.println(lengthOfLongestSubString.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubString.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubString.lengthOfLongestSubstring("pwwkew"));
    }
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int leftIndex = 0;
        int rightIndex = 0;
        int max = 0;
        Map<Character, Integer> characterSet = new HashMap();
        while (rightIndex < chars.length) {
            characterSet.computeIfPresent(chars[rightIndex], (key, value) -> value + 1);
            characterSet.putIfAbsent(chars[rightIndex], 1);

            while (rightIndex - leftIndex + 1 > characterSet.size()) {
                Integer count = characterSet.get(chars[leftIndex]);
                if (count == 1) {
                    characterSet.remove(chars[leftIndex]);
                } else {
                    characterSet.put(chars[leftIndex], count - 1);
                }
                leftIndex++;
            }

            max = Math.max(max, (rightIndex - leftIndex + 1));

            rightIndex++;
        }
        return max;
    }
}
