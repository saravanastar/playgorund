package com.ask.workout.algo.leetcode3;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class AsteroidCollision {

    public static void main(String[] args) {
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        print(asteroidCollision.asteroidCollision(new int[]{5,10,-5}));
        print(asteroidCollision.asteroidCollision(new int[]{5,-5}));
        print(asteroidCollision.asteroidCollision(new int[]{10, 2,-5}));

    }

    private static void print(int[] result) {
        Arrays.stream(result).forEach(val -> System.out.print(val + "\t"));
        System.out.println();
    }

    public int[] asteroidCollision(int[] asteroids) {

        Deque<Integer> stack = new LinkedList<>();
        for (int asteriod: asteroids) {
            boolean elseLogic = false;
            int peek = stack.peek();
            while (!stack.isEmpty() && asteriod < 0 && peek > 0) {
                peek = stack.peek();
                if (peek < Math.abs(asteriod)) {
                    stack.pop();
                } else if (peek == Math.abs(asteriod)) {
                    stack.pop();
                }
                elseLogic = true;
                break;
            }
            if (!elseLogic) {
                stack.push(asteriod);
            }
        }
        int[] result = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            result[index++] = stack.removeLast();
        }
       return result;

    }
}
