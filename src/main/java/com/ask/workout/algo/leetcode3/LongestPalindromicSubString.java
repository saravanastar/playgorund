package com.ask.workout.algo.leetcode3;

public class LongestPalindromicSubString {
    public static void main(String[] args) {
        LongestPalindromicSubString longestPalindromicSubString = new LongestPalindromicSubString();
//        System.out.println(longestPalindromicSubString.longestPalindrome("babad"));
//        System.out.println(longestPalindromicSubString.longestPalindrome("cbbd"));
        System.out.println(longestPalindromicSubString.longestPalindrome("abb"));
    }
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length <= 1) {
            return s;
        }
        int currentIndex = 0;
        int maxLen = 0;
        String result = String.valueOf(chars[0]);
        while (currentIndex < chars.length-1) {
            int leftIndex = currentIndex;
            int rightIndex = currentIndex;
            String odd = expandAround(s, leftIndex, rightIndex);
            String even = expandAround(s, leftIndex, rightIndex+1);

            if (odd.length() > maxLen) {
                result = odd;
                maxLen = odd.length();
            }
            if (even.length() > maxLen) {
                result = even;
                maxLen = even.length();
            }
            currentIndex++;
        }
        return result;
    }

    public String expandAround(String chars, int leftIndex, int rightIndex) {
        while (leftIndex>=0 && rightIndex < chars.length() && chars.charAt(rightIndex) == chars.charAt(leftIndex)) {
            rightIndex++;
            leftIndex--;
        }
        return chars.substring(leftIndex+1, rightIndex);
    }
}
