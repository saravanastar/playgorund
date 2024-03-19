package com.ask.workout.algo.leetcode3;

public class SmallCalc {
    public static void main(String[] args) {
        SmallCalc smallCalc = new SmallCalc();
        System.out.println(smallCalc.calc("2*3+4"));
        System.out.println(smallCalc.calc("5*2*3+4"));
    }
    public int calc(String input) {
        if (input.length() ==0) {
            return 0;
        }
        int currentIndex = 0;
        int carrier = 0;
        char[] chars = input.toCharArray();
        while (currentIndex < chars.length) {
            if (currentIndex ==0) {
                StringBuilder stringBuilder = new StringBuilder();
                while (currentIndex < chars.length && chars[currentIndex] != '+' && chars[currentIndex] != '*') {
                    stringBuilder.append(chars[currentIndex]);
                    currentIndex++;
                }
                carrier = Integer.valueOf(stringBuilder.toString());
            }
            char operator = chars[currentIndex];
            currentIndex++;
            StringBuilder stringBuilder = new StringBuilder();
            while (currentIndex < chars.length && chars[currentIndex] != '+' && chars[currentIndex] != '*') {
                stringBuilder.append(chars[currentIndex]);
                currentIndex++;
            }
            int rightOperand = Integer.valueOf(stringBuilder.toString());

            if (operator == '*') {
                carrier = carrier * rightOperand;
            } else {
                carrier = carrier + rightOperand;
            }
        }
        return carrier;
    }
}
