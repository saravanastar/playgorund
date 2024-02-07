package com.ask.workout.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
//        System.out.println(longestRepeatingCharacterReplacement.characterReplacement("ABAB", 2));
        System.out.println(longestRepeatingCharacterReplacement.characterReplacement("AABABBA", 1));
//        System.out.println(longestRepeatingCharacterReplacement.characterReplacement("BAAA", 0));
//        System.out.println(longestRepeatingCharacterReplacement.characterReplacement("ABBB", 2));
    }

    public int characterReplacement(String s, int k) {
       int maxLen = 0;
       int left = 0;
       int right =0;
       int mostFreq = 0;
       char[] charArray = s.toCharArray();
       Map<Character, Integer> lookup = new HashMap<>();
       while (right < charArray.length) {
           lookup.computeIfPresent(charArray[right], (key, val) -> val + 1);
           lookup.computeIfAbsent(charArray[right], (key) -> 1);
           mostFreq = Math.max(lookup.get(charArray[right]), mostFreq);

           if ((right-left+1) - mostFreq > k) {
               mostFreq = Math.max(lookup.get(charArray[left]), mostFreq);
               lookup.computeIfPresent(charArray[left], (key, val) -> val - 1);
               left++;
           }
           maxLen = Math.max(maxLen, (right-left) + 1);
           right++;

       }
       return maxLen;
    }
}
