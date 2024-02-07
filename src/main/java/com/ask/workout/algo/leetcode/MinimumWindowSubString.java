package com.ask.workout.algo.leetcode;

/**
 * https://leetcode.com/problems/minimum-window-substring/description/
 */
public class MinimumWindowSubString {
    public static void main(String[] args) {
        MinimumWindowSubString minimumWindowSubString = new MinimumWindowSubString();
        System.out.println(minimumWindowSubString.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minimumWindowSubString.minWindow("a", "a"));
        System.out.println(minimumWindowSubString.minWindow("a", "aa"));
    }
    public String minWindow(String s, String t) {
        char[] tArray = t.toCharArray();
        int[] map = new int[128];
        for (char c : tArray) {
            map[c]++;
        }
        int left = 0;
        int right = 0;
        int count = t.length();
        char[] sArray = s.toCharArray();
        int max = Integer.MAX_VALUE;
        String result = "";
        while (right < sArray.length) {
            if(map[sArray[right++]]-- > 0) {
                count--;
            }

            while (count == 0) {
                if ((right-left) < max) {
                    max = (right-left);
                    result = s.substring(left, right);
                }
                if (++map[sArray[left++]] > 0) count++;
            }

        }

        return result;
    }
}
