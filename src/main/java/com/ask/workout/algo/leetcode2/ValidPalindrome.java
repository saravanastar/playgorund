package com.ask.workout.algo.leetcode2;

/**
 * https://leetcode.com/problems/valid-palindrome/submissions/
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindrome("race a car"));
        System.out.println(validPalindrome.isPalindrome(" "));
    }

    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 1) return true;
        int left = 0;
        int right = s.length() -1;
        while (left < right) {
            char leftChar = s.charAt(left);
            if ((!Character.isAlphabetic(leftChar) && !Character.isDigit(leftChar))) {
                left++;
                continue;
            }
            char rightChar = s.charAt(right);
            if ((!Character.isAlphabetic(rightChar) && !Character.isDigit(rightChar))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) return false;
            left++;
            right--;
        }

        return true;

    }
}
