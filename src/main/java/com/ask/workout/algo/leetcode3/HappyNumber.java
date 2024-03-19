package com.ask.workout.algo.leetcode3;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(19));
        System.out.println(happyNumber.isHappy(2));
    }

    public boolean isHappy(int n) {
        int sum = 0;
        Set<String> lookup = new HashSet<>();
        String stringNumber = String.valueOf(n);
        while(!lookup.contains(stringNumber)) {
            lookup.add(stringNumber);
            sum =0;
            for (int index = 0; index < stringNumber.length(); index++) {
                int val = Integer.parseInt(String.valueOf(stringNumber.charAt(index)));
                sum+= val*val;
            }
            if (sum == 1) return true;
            stringNumber = String.valueOf(sum);
        }
        return false;
    }
}
