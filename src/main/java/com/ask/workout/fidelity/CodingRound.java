package com.ask.workout.fidelity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CodingRound {

    public static void main(String[] args) {
        CodingRound codingRound = new CodingRound();
        System.out.println(codingRound.removeDuplicates("aec"));
        System.out.println(codingRound.removeDuplicates("caebdac"));
        System.out.println(codingRound.removeDuplicates("c"));
        System.out.println(codingRound.removeDuplicates(""));

    }
    // input = "caebdac"
    // output = "bde"
    /**
     * sorted_input = "aabccde"
     * output_array = []
     * index =1
     * for index = 1 range(len(sorted_input))
     * if input[index] == input[index-1]:
     *      index++
     * else:
     *     output[output_index] = input[index]
     *
     *
     * return String.valueOf(output)
     *
     * run time complexity = nlog(n) + n
     * space complexity = o(log(n))
     *
     *
     *
     */

    /**
     *
     *
     */
    public String removeDuplicates(final String input) {
        // base case
        if(input.length() <= 1) {
            return input;
        }
        Set<Character> output = new HashSet<>();
        int[] lookup = new int[128];
        char[] inputArray = input.toCharArray();
        for (int i = 0; i < inputArray.length; i++) {
            ++lookup[inputArray[i]];

            if(lookup[inputArray[i]] > 1) {
                output.remove(inputArray[i]);
            } else {
                output.add(inputArray[i]);
            }
        }
        return output.toString();
    }
}
