package com.ask.workout.algo.leetcode3;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode.com/problems/removing-stars-from-a-string
 */
public class RemoveStars {

    public String removeStars(String s) {
        Deque<Character> queue = new LinkedList<>();

        char[] chars = s.toCharArray();
        for (char val: chars) {
            if (val == '*') {
                queue.pop();
            } else {
                queue.push(val);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            result.append(queue.removeLast());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        RemoveStars removeStars = new RemoveStars();
        System.out.println(removeStars.removeStars("leet**cod*e"));
    }
}
