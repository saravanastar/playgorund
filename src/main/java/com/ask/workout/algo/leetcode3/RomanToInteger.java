package com.ask.workout.algo.leetcode3;


import java.util.*;

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger romanToInteger  = new RomanToInteger();
//        System.out.println(romanToInteger.romanToInt("II"));
//        System.out.println(romanToInteger.romanToInt("XII"));
//        System.out.println(romanToInteger.romanToInt("IX"));
//        System.out.println(romanToInteger.romanToInt("IVX"));
//        System.out.println(romanToInteger.romanToInt("XLC"));
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }
    public int romanToInt(String s) {
//        Deque<Integer> holder = new ArrayDeque<>();
        Map<Character, Integer> lookup = new HashMap<>();
        lookup.put('I',1);
        lookup.put('V',5);
        lookup.put('V',5);
        lookup.put('X',10);
        lookup.put('L',50);
        lookup.put('C',100);
        lookup.put('D',500);
        lookup.put('M',1000);

        int current_index = 0;
        char[] chars = s.toCharArray();
        int sum = 0;
        while (current_index < chars.length) {
            int currentNumber = lookup.get(chars[current_index]);
            if (current_index + 1 < chars.length) {
                int nextNumber = lookup.get(chars[current_index+1]);
                if (currentNumber < nextNumber) {
                    sum -= currentNumber;
                } else {
                    sum+=currentNumber;
                }
            } else {
                sum+=currentNumber;
            }
            current_index++;
        }
        return sum;
//        while (current_index < chars.length) {
//            if(current_index == 0) {
//                int firstNumber = lookup.get(chars[0]);
//                int lastNumber = lookup.get(chars[chars.length-1]);
//                if(firstNumber >= lastNumber) {
//                    int currentElement = lookup.get(chars[current_index]);
////                    int result = (int) (Math.pow(10, chars.length - (current_index+1)) * currentElement);
//                    holder.offer(currentElement);
//                }
//                current_index++;
//                continue;
//            }
//            int previousElement = lookup.get(chars[current_index-1]);
//            int currentElement = lookup.get(chars[current_index]);
//            if (currentElement > previousElement) {
//                int result = currentElement - (holder.isEmpty() ? 0: holder.pop());
//                holder.offer(result);
//            } else {
//
//                holder.offer(currentElement);
//            }
//            current_index++;
//        }
//        return holder.stream().reduce(0, (i1, i2) -> i1 + i2);


    }
}
