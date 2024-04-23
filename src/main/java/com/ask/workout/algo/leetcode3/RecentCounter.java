package com.ask.workout.algo.leetcode3;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> holder;
    public RecentCounter() {
        holder = new LinkedList<>();
    }

    public int ping(int t) {
        holder.add(t);

        while (!holder.isEmpty() && holder.peek() < t - 3000) {
            holder.poll();
        }
        return holder.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
}
