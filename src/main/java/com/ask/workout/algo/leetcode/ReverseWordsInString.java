package com.ask.workout.algo.leetcode;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 */
public class ReverseWordsInString {

    public static void main(String[] args) {
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        System.out.println(reverseWordsInString.reverseWords("the sky is blue"));
        System.out.println(reverseWordsInString.reverseWords("  hello world  "));
        System.out.println(reverseWordsInString.reverseWords("a good   example"));
        System.out.println(reverseWordsInString.reverseWords("EPY2giL"));
    }

    public String reverseWords(String s) {
        if (s.isEmpty()) return s;
        StringBuilder stringBuilder = new StringBuilder();
        int currentIndex = s.length() - 1;
        while (currentIndex >= 0) {
            if ((int) s.charAt(currentIndex) == 32) {
                currentIndex -= 1;
                continue;
            }
            int wordIndex = currentIndex;
            while (wordIndex >= 0 && (int) s.charAt(wordIndex) != 32) {
                wordIndex--;
            }
            stringBuilder.append(s, wordIndex + 1, currentIndex + 1).append(" ");
            currentIndex = wordIndex - 1;
        }

        return stringBuilder.toString().trim();
    }

    private void swap(int left, int right, String[] splitArray) {
        String temp = splitArray[left];
        splitArray[left] = splitArray[right];
        splitArray[right] = temp;
    }
}
