package com.ask.workout.algo.leetcode3;

import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string
 */
public class DecodeString {
    int currentIndex = 0;
    public static void main(String[] args) {
        DecodeString string = new DecodeString();
        System.out.println(string.decodeString("3[a]2[bc]"));
        System.out.println(string.decodeString("3[a2[c]]"));
        System.out.println(string.decodeString("2[abc]3[cd]ef"));
    }

    public String decodeString(String s) {
        currentIndex = 0;
        return decodeString(s.toCharArray());
    }

    public String decodeString(char[] input) {
        Stack<String> stack = new Stack<>();
        while (currentIndex < input.length) {
            if (input[currentIndex] == '[') {
                currentIndex++;
                String result = decodeString(input);
                stack.push(result);
                stack.push(format(stack));
            } else if (input[currentIndex] == ']') {
                break;
            } else if (isNumeric(String.valueOf(input[currentIndex]))) {
                if (stack.isEmpty()) {
                    int total =  (input[currentIndex] - '0');
                    stack.push(String.valueOf(total));
                    currentIndex++;
                    continue;
                }
                String pop = stack.pop();
                if (isNumeric(pop)) {
                    int total = 10 * Integer.valueOf(pop) + (input[currentIndex] - '0');
                    stack.push(String.valueOf(total));
                } else {
                    stack.push(pop);
                    int total =  (input[currentIndex] - '0');
                    stack.push(String.valueOf(total));
                }
            } else {
                String pop = stack.isEmpty()? "" : stack.pop();
                stack.push(pop + input[currentIndex]);
            }
            currentIndex++;
        }

        return format(stack);
    }

    private String format(Stack<String> stack) {
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            String val = stack.pop();
            if (isNumeric(val)) {
                int count = Integer.valueOf(val);
                result.append(multiply(count, result.toString()));
            } else {
                result.insert(0, val);
            }
        }
        return result.toString();
    }

    private StringBuilder multiply(int count, String result) {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < count-1; index++) {
            builder.append(result);
        }
        return builder;
    }

    private boolean isNumeric(String input) {

        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

}

/**
 * 3[a2[c]]
 *
 * 3[a
 *
 *
 */
