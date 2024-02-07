package com.ask.workout.algo.leetcode2;

import java.util.*;

public class ValidParenthesis {

    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        System.out.println(validParenthesis.isValid("(){}}{"));
    }

    public boolean isValid(String s) {
        Map<Character, Character> lookup = new HashMap<>();
        lookup.put(')', '(');
        lookup.put('}','{');
        lookup.put(']', '[');
        char[] input = s.toCharArray();
        Deque<Character> store = new LinkedList<>();
        for(int index = 0;index < input.length; index++) {
            char current = input[index];
            if (lookup.containsKey(current)) {
                if (store.isEmpty() || !lookup.get(current).equals(store.pop())) return false;
            } else {
                store.push(current);
            }
        }
        return store.isEmpty();
    }
}
