package com.ask.workout.algo.leetcode3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/dota2-senate/description
 */
public class Dota2Senate {

    public static void main(String[] args) {
        Dota2Senate dota2Senate = new Dota2Senate();
        System.out.println(dota2Senate.predictPartyVictory("RD"));
        System.out.println(dota2Senate.predictPartyVictory("RDD"));
        System.out.println(dota2Senate.predictPartyVictory("DDRRR"));
    }

    public String predictPartyVictory(String senate) {
        Queue<Integer> rQueues = new LinkedList<>();
        Queue<Integer> dQueues = new LinkedList<>();
        for (int index = 0; index < senate.length(); index++) {
            if (senate.charAt(index) == 'R') {
                rQueues.add(index);
            } else {
                dQueues.add(index);
            }
        }

        while (!rQueues.isEmpty() && !dQueues.isEmpty()) {
            int popR = rQueues.poll();
            int popD = dQueues.poll();
            if (popR < popD) {
                rQueues.add(popR+ senate.length());
            } else {
                dQueues.add(popD+ senate.length());
            }
        }

        return dQueues.isEmpty() ? "Radiant" : "Dire";

    }
}
