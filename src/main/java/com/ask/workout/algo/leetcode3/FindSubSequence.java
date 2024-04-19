package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/is-subsequence
 */
public class FindSubSequence {

    public static void main(String[] args) {
        FindSubSequence findSubSequence = new FindSubSequence();
        System.out.println(findSubSequence.isSubsequence("abc", "ahbgdc"));
        System.out.println(findSubSequence.isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < s.length()) {
            if (tIndex >= t.length()) {
                return false;
            }
            if (t.charAt(tIndex) == s.charAt(sIndex)) {
                if (sIndex == s.length()-1) {
                    return true;
                }
                sIndex++;
            }

            tIndex++;

        }


        return false;
    }
}
