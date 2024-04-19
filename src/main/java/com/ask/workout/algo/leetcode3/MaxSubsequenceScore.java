package com.ask.workout.algo.leetcode3;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-subsequence-score/description
 */
public class MaxSubsequenceScore {

    public static void main(String[] args) {
        MaxSubsequenceScore maxSubsequenceScore = new MaxSubsequenceScore();
//        int[] nums1 = {1,3,3,2};
//        int[] nums2 = {2,1,3,4};
//        int k = 3;
        int[] nums1 = {4,2,3,1,1};
        int[] nums2 = {7,5,10,9,6};
        int k = 1;
        System.out.println(maxSubsequenceScore.maxScore(nums1, nums2, k));

    }

    record Pair(int a, int b) {}
    public long maxScore(int[] a, int[] b, int k) {
        int n = a.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; ++i) pairs[i] = new Pair(a[i], b[i]);
        Arrays.sort(pairs, (x, y) -> y.b - x.b);
        Queue<Integer> q = new PriorityQueue<>(k+1);
        long res = 0, sum = 0;
        for (var p : pairs) {
            q.add(p.a);
            sum += p.a;
            if (q.size() > k) sum -= q.poll();
            if (q.size() == k) res = Math.max(res, sum * p.b);
        }
        return res;
    }

//    public long maxScore(int[] nums1, int[] nums2, int k) {
//       return maxScore(nums1, nums2, k, 0, 0, Integer.MAX_VALUE);
//    }

    /**
     * This brings 0(n^2) run time complexity
     */
    public long maxScore(int[] nums1, int[] nums2, int k, int currentIndex, long sum, long min) {
        if (k ==0) {
            return sum * min;
        }
        if (k < 0 || currentIndex >= nums1.length) {
            return 0;
        }

        long max1 = maxScore(nums1, nums2, k-1, currentIndex + 1, sum+nums1[currentIndex],Math.min(min, nums2[currentIndex]));
        long max2 = maxScore(nums1, nums2, k, currentIndex + 1, sum,min);
        return Math.max(max1, max2);
    }
}
