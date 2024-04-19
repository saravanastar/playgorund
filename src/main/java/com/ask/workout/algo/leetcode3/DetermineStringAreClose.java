package com.ask.workout.algo.leetcode3;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/determine-if-two-strings-are-close
 */
public class DetermineStringAreClose {

    public static void main(String[] args) {
        DetermineStringAreClose determineStringAreClose = new DetermineStringAreClose();
        System.out.println(determineStringAreClose.closeStrings("abc", "bca"));
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int index = 0; index < word1.length(); index++) {
            count1[word1.charAt(index) - 'a']++;
        }
        for (int index = 0; index < word2.length(); index++) {
            count2[word2.charAt(index) - 'a']++;
        }

        for (int index = 0; index < 26; index++) {
            if ((count1[index] == 0 && count2[index] != 0) || (count1[index] != 0 && count2[index] == 0)) return false;
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        return Arrays.equals(count1, count2);
    }
}
