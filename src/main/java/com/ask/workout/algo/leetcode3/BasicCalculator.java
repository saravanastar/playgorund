package com.ask.workout.algo.leetcode3;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator/description/
 */
public class BasicCalculator {

    int index;
    int currentIndex = 0;
    public static void main(String[] args) {
        BasicCalculator basicCalculator = new BasicCalculator();

        System.out.println(basicCalculator.calculateThirdMethod("(1+(4+5+2)-3)+(6+8)"));
//        System.out.println(basicCalculator.calculateThirdMethod("1"));
//        System.out.println(basicCalculator.calculateThirdMethod("1-(     -2)"));
    }


    public int calculateThirdMethod(String s) {
        currentIndex = 0;
        return helperThirdMethod(s);
    }

    private int helperThirdMethod(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        Character symbol = '+';
        int number = 0;
        char[] chars = s.toCharArray();
//        int currentIndex = 0;
        int end = chars.length;

        while (currentIndex < end) {
            Character character = chars[currentIndex];
            if (Character.isDigit(character)) {
                number = 10 * number + (int)(character - '0');
            }

            if (character.equals('(')) {
                currentIndex++;
                number = helperThirdMethod(s);
            }

            if (currentIndex == chars.length -1 || character.equals('+') || character.equals('-') || character.equals('*') || character.equals('/') || character.equals(')')) {

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
                if (character.equals(')')) {
                    break;
                }
            }


            currentIndex++;
        }

        while (!stack.empty()) {
            result+=stack.pop();
        }
        return result;
    }

    public int calculateRecursion(String s) {
        index = 0;
        return recursive(s);
    }
    public int recursive(String s) {
        int result = 0;
        int sign = 1;
        int number = 0;
        while (index < s.length()) {
            Character character = s.charAt(index);
            if(Character.isDigit(character)) {
                number = 10 * number + (int)(character - '0');
            } else if (character.equals('(')) {
                index++;
                number = recursive(s);
            } else if (character.equals(')')) {
                result += number * sign;
                return result;
            } else if (character.equals('+')) {
                result += number * sign;
                number = 0;
                sign = 1;
            } else if (character.equals('-')) {
                result += number * sign;
                number = 0;
                sign = -1;
            }
            index++;
        }

        if (number !=0) result+=number*sign;
        return result;
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int sign = 1;
        int number = 0;
        char[] chars = s.toCharArray();
        int currentIndex = 0;
        while (currentIndex < chars.length) {
            Character character = chars[currentIndex];
            if (Character.isDigit(character)) {
                number = 10 * number + (int)(character - '0');
            } else if (character.equals('+')) {
                result+=number*sign;
                number = 0;
                sign = 1;
            } else if (character.equals('-')) {
                result+=number*sign;
                number = 0;
                sign = -1;
            } else if (character.equals('(')) {
                result += number * sign;
                stack.push(result);
                stack.push(sign);
                number = 0;
                result = 0;
                sign = 1;
            } else if (character.equals(')')) {
                result += number * sign;
                result *= stack.pop();
                result += stack.pop();
                number = 0;
            }

            currentIndex++;
        }

        if (number !=0) result += sign * number;
        return result;

    }


}
