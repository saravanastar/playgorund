package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/merge-strings-alternately
 */
public class MergeStringAlernatively {

    public static void main(String[] args) {
        MergeStringAlernatively mergeStringAlernatively = new MergeStringAlernatively();
        System.out.println(mergeStringAlernatively.mergeAlternately("abcd", "pq"));
    }

    public String mergeAlternately(String word1, String word2) {
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();
        char[] result = new char[word1Chars.length + word2Chars.length];
        int word1Index = 0;
        int word2Index = 0;
        int resultIndex = 0;
        while(word1Index < word1Chars.length && word2Index < word2Chars.length) {
            result[resultIndex++] = word1Chars[word1Index];
            result[resultIndex++] = word2Chars[word2Index];
            word1Index++;
            word2Index++;
        }

        while (word1Index < word1Chars.length) {
            result[resultIndex++] = word1Chars[word1Index];
            word1Index++;
        }

        while (word2Index < word2Chars.length) {
            result[resultIndex++] = word2Chars[word2Index];
            word2Index++;
        }

        return String.valueOf(result).trim();

    }
}
