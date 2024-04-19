package com.ask.workout.algo.leetcode3;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/smallest-number-in-infinite-set
 */
class SmallestInfiniteSet {

    TreeSet<Integer> holder;

    public SmallestInfiniteSet() {
        holder = new TreeSet<>();

        for (int index = 0; index <= 1000; index++) {
            holder.add(index + 1);
        }
    }

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        System.out.println(smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(1);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(2);
        smallestInfiniteSet.addBack(3);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());

    }

    public int popSmallest() {
        int smallest = holder.first();
        holder.remove(smallest);
        return smallest;
    }

    public void addBack(int num) {
        holder.add(num);
    }
}
