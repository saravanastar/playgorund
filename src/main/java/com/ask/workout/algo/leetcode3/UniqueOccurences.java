package com.ask.workout.algo.leetcode3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences
 */
public class UniqueOccurences {

    public static void main(String[] args) {
        UniqueOccurences uniqueOccurences = new UniqueOccurences();
        System.out.println(uniqueOccurences.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> lookup = new HashMap<>();

        for (int num: arr) {
            lookup.computeIfPresent(num, (key, val) -> val + 1);
            lookup.putIfAbsent(num, 1);
        }
        Set<Integer> dupCheck = new HashSet<>();
        Set<Map.Entry<Integer, Integer>> datas = lookup.entrySet();
        for (Map.Entry<Integer, Integer> data: datas) {
            if (dupCheck.contains(data.getValue())) {
                return false;
            }
            dupCheck.add(data.getValue());
        }
        return true;
    }
}
