package com.ask.workout.algo.leetcode3;

import java.util.*;

public class MinimumRemoveToMakeValidParenthesis {
    public static void main(String[] args) {
        MinimumRemoveToMakeValidParenthesis mr = new MinimumRemoveToMakeValidParenthesis();
//        System.out.println(mr.minRemoveToMakeValid("lee(t(c)o)de)"));
//        System.out.println(mr.minRemoveToMakeValid("a)b(c)d)"));
        System.out.println(mr.minRemoveToMakeValid("))(("));
    }

    /**
     *
     *
     */


    public String minRemoveToMakeValid(String str) {
        int n = str.length();
        StringBuilder sb = new StringBuilder(n);
        boolean[] remove = new boolean[n];
        int open = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(') {
                open++;
            } else if (str.charAt(i) == ')') {
                if (open > 0) {
                    open--;
                } else {
                    remove[i] = true;
                }
            }
        }

        int close = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == ')') {
                close++;
            } else if (str.charAt(i) == '(') {
                if (close > 0) {
                    close--;
                } else {
                    remove[i] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!remove[i]) sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    public String minRemoveToMakeValid2(String str) {
        int n = str.length();
        StringBuilder sb = new StringBuilder(n);
        Stack<Integer> integers = new Stack<>();
        Set<Integer> removeIndices = new HashSet<>();
        for (int index = 0; index < str.length(); index++) {
            if(str.charAt(index) == '(') {
                integers.push(index);
            } else if(str.charAt(index) == ')') {
                if(integers.empty()) {
                    removeIndices.add(index);
                } else {
                    integers.pop();
                }
            }
        }
        while (!integers.empty()) {
            removeIndices.add(integers.pop());
        }
        for (int index = 0; index < str.length(); index++) {
            if (!removeIndices.contains(index)) {
                sb.append(str.charAt(index));
            }
        }

        return sb.toString();
    }
}
