package com.ask.workout.algo.leetcode3;

public class ReverseWordInString {

    public static void main(String[] args) {
        ReverseWordInString reverseWordInString = new ReverseWordInString();
        System.out.println(reverseWordInString.reverseWords("the sky is blue"));
        System.out.println(reverseWordInString.reverseWords("  hello world  "));
        System.out.println(reverseWordInString.reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int rightIndex = chars.length-1;
        int leftIndex = chars.length-1;
        StringBuilder result = new StringBuilder();
        while (leftIndex >=0) {
            while (rightIndex >=0 && chars[rightIndex] == ' ') {
                rightIndex--;
                leftIndex--;
            }

            while (leftIndex >= 0 && Character.isLetterOrDigit(chars[leftIndex])) {
                leftIndex--;
            }
            result.append(s.substring(leftIndex+1, rightIndex+1));
            result.append(" ");
            rightIndex = leftIndex;
        }
        return result.toString().trim();
    }
}
