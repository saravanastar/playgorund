package com.ask.workout.algo.leetcode3;


import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description
 */
public class ReverseVowelOfString {
    Set<Character> vowelBag;
    public static void main(String[] args) {
        ReverseVowelOfString reverseVowelOfString = new ReverseVowelOfString();
        System.out.println(reverseVowelOfString.reverseVowels("hello"));
        System.out.println(reverseVowelOfString.reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        vowelBag = new HashSet<>();
        vowelBag.add('a');
        vowelBag.add('A');
        vowelBag.add('e');
        vowelBag.add('E');
        vowelBag.add('i');
        vowelBag.add('I');
        vowelBag.add('o');
        vowelBag.add('O');
        vowelBag.add('u');
        vowelBag.add('U');
        if (s == null || s.isEmpty()) {
            return s;
        }
        return reverseVowelsRecursive(s.toCharArray());
    }

    public String reverseVowelsRecursive(char[] chars) {
        int leftIndex = 0;
        int rightIndex = chars.length-1;
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && (!vowelBag.contains(chars[leftIndex]) || !vowelBag.contains(chars[rightIndex]))) {

                if (!vowelBag.contains(chars[leftIndex])) {
                    leftIndex++;
                }

                if (!vowelBag.contains(chars[rightIndex])) {
                    rightIndex--;
                }

            }
            if (vowelBag.contains(chars[leftIndex]) && vowelBag.contains(chars[rightIndex])) {
                swap(chars, leftIndex, rightIndex);
            }
            leftIndex++;
            rightIndex--;
        }

        return String.valueOf(chars);
    }

    private void swap(char[] chars, int leftIndex, int rightIndex) {
        char temp = chars[leftIndex];
        chars[leftIndex] = chars[rightIndex];
        chars[rightIndex] = temp;
    }

}
