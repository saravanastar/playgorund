package com.ask.workout.algo.leetcode3;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class BasicCalculatorII {

    public static void main(String[] args) {
        BasicCalculatorII basicCalculatorII = new BasicCalculatorII();
        System.out.println(basicCalculatorII.calculate("3+2*2"));
    }



    public int calculate(String s) {
        int result = 0;
        int number = 0;
        Character symbol = '+';
        char[] chars = s.toCharArray();
        int currentIndex = 0;
        Stack<Integer> stack = new Stack<>();
        while (currentIndex < chars.length) {
            Character character = chars[currentIndex];
            if (Character.isDigit(character)) {
                number = 10 * number + (int) (character - '0');
            }
            if (character.equals('+') || character.equals('-') || character.equals('*') || character.equals('/') || currentIndex == chars.length - 1) {

                if (symbol.equals('+')) {
                    stack.push(number);
                } else if (symbol.equals('-')) {
                    stack.push(-number);
                } else if (symbol.equals('*')) {
                    stack.push(stack.pop() * number);
                } else if (symbol.equals('/')) {
                    stack.push(stack.pop() / number);
                }
                number = 0;
                symbol = character;
            }
            currentIndex++;
        }

        while (!stack.empty()) {
            result+=stack.pop();
        }

        return result;
    }
}
