package com.ask.workout.algo.leetcode3;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        RemoveDuplicateLetters duplicateLetters = new RemoveDuplicateLetters();
//        System.out.println(duplicateLetters.removeDuplicateLetters("bcabc"));
        System.out.println(duplicateLetters.removeDuplicateLetters("cbacdcbc"));
    }

    public String removeDuplicateLetters(String s) {
        int[] lastIndexArray = new int[26];

        char[] chars = s.toCharArray();
        for (int index = 0; index < chars.length; index++) {
            lastIndexArray[chars[index] - 'a'] = index;
        }
        final Stack<Integer> stack = new Stack<>();
        final boolean[] seen = new boolean[26];
       for (int index = 0; index < chars.length; index++) {
            int charIndex = chars[index] - 'a';
            if (seen[charIndex]) {
                continue;
            } else {

                while (!stack.empty() && stack.peek() > charIndex && index < lastIndexArray[stack.peek()]) {
                    seen[stack.pop()] = false;
                }
                stack.push(charIndex);
                seen[charIndex] = true;
            }

        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty())
            result.append((char) (stack.pop() + 'a'));
        return result.reverse().toString();
    }
}
