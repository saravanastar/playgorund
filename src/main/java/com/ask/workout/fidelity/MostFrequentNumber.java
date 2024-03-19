package com.ask.workout.fidelity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MostFrequentNumber {


    public static void main(String[] args) {
        MostFrequentNumber frequentNumber = new MostFrequentNumber();
        System.out.println(frequentNumber.mostFrequentNumber(new int[] {1, 2, 3, 4, 1, 2, 2,3,3, 3}));
    }

    /**
     *  [1, 2, 3, 4, 1]
     *   max_count = Integer.min_val
     *   lookup<value, frequency> = {}
     *   max_frquent_number = 0
     *   for i =0 to n-1
     *
     *      int count = lookup.get(input[i]).else(0) + 1
     *      if count > max_count:
     *          max_frquent_number = input[i]
     *       lookup.put(input[i], count)
     *
     *
     *     return max_frequent_number
     *
     *     max_value = Integer.min
     *     for i = 0  to n-1
     *      in freq = Collections.frequency(input, input.get(i))
     *      max_value = Math.max(max_value, freq)03/0
     *
     *     return max_value

     */


    public int mostFrequentNumber(int[] input) {
       int maxCount = Integer.MIN_VALUE;
       Map<Integer, Integer> lookup = new HashMap<>();
       int maxFrequentNumber = 0;
        for (int index = 0; index < input.length; index++) {
            int count = Optional.ofNullable(lookup.get(input[index])).orElse(0) + 1;
            if (count > maxCount) {
                maxFrequentNumber = input[index];
            }
            lookup.put(input[index], count);

        }
        return maxFrequentNumber;
    }
}
