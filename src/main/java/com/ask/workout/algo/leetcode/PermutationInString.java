package com.ask.workout.algo.leetcode;

/**
 * https://leetcode.com/problems/permutation-in-string/submissions/
 */
public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString permutation = new PermutationInString();
        System.out.println(permutation.checkInclusion("ab", "eidbaooo"));
//        System.out.println(permutation.checkInclusion("ab", "eidboaoo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[128];
        char[] s1Array = s1.toCharArray();
        for (int index = 0; index < s1Array.length; index++) {
            map[s1Array[index]]++;
        }
        int count = s1Array.length;
        int left = 0;
        int right = 0;
        char[] s2Array = s2.toCharArray();
        while (right < s2Array.length) {
            if (map[s2Array[right++]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (right-left == s1.length()) return true;
                if (++map[s2Array[left++]] > 0) count++;
            }
        }

        return false;
    }
}
