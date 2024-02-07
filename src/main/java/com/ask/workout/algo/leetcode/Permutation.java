package com.ask.workout.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Permutation {


    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        Set<String> stringList = new HashSet<>();
        permutation.findPermutation("ABC", 0, stringList);
        stringList.forEach(System.out::println);
        System.out.println(stringList.size());
    }

    /**
     * A B C D
     * fixed = 0
     * ABCD, BACD, CBAD, DBCA
     */
    private void findPermutation(String original, int fixed, Set<String> output) {
        char[] inputArray = original.toCharArray();
        for (int index = fixed; index < original.length(); index++) {
            String permuteString = swap(inputArray, fixed, index);
            output.add(permuteString);
            if (fixed + 1 < original.length() -1)
                findPermutation(permuteString, fixed + 1, output);
        }
    }

    private String swap(char[] inputArray, int source, int dest) {
        char temp = inputArray[source];
        inputArray[source] = inputArray[dest];
        inputArray[dest] = temp;
        return String.valueOf(inputArray);
    }
}
