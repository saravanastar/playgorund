package com.ask.workout.algo.leetcode2;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram/submissions/
 */
public class ValidAnagram {

    public static void main(String[] args) {
            ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram", "nagarag"));
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> lookup = new HashMap<>();

        char[] s1 = s.toCharArray();
        for (Character character: s1) {
            lookup.computeIfPresent(character, (key, val) -> val + 1);
            lookup.putIfAbsent(character, 1);
        }

        char[] s2 = t.toCharArray();
        for (Character character: s2) {
            if (lookup.containsKey(character)) {
                int count = lookup.get(character);
                if (count == 1) {
                    lookup.remove(character);
                    continue;
                }
                lookup.put(character, count - 1);
            } else {
                lookup.putIfAbsent(character, 1);
            }
        }


        return lookup.isEmpty();

    }
}
