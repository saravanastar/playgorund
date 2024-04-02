package com.ask.workout.algo.leetcode3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KFrequentElement {

    public static void main(String[] args) {
        KFrequentElement kFrequentElement = new KFrequentElement();
        print(kFrequentElement.topKFrequent(new int[]{1,1,1,2,2,3}, 2));
        print(kFrequentElement.topKFrequent(new int[]{1}, 1));

    }

    public static  void print(int[] ints) {
        Arrays.stream(ints).forEach(number -> System.out.print(number + "\t"));
        System.out.println();
    }


    public int[] topKFrequent(int[] nums, int k) {
        // value and frequency
        Map<Integer, Integer> lookup = new HashMap<>();

        for (int num :
                nums) {
            lookup.put(num, lookup.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> mapPriorityQueue = new PriorityQueue<>((entry1, entry2) -> entry2.getValue() - entry1.getValue());

        lookup.entrySet().stream().forEach(integerIntegerEntry -> {
            mapPriorityQueue.offer(integerIntegerEntry);

        });

        int[] result = new int[k];
        for (int index = 0; index < k; index++) {
            result[index] = mapPriorityQueue.poll().getKey();
        }
        return result;
    }
}
