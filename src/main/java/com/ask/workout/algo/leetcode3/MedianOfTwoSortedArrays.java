package com.ask.workout.algo.leetcode3;


/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] holder = new int[m + n];
        int mIndex = 0;
        int nIndex = 0;
        int currentIndex = 0;
        while (mIndex < m && nIndex < n) {
            if (nums1[mIndex] < nums2[nIndex]) {
                holder[currentIndex] = nums1[mIndex];
                mIndex++;
            } else {
                holder[currentIndex] = nums2[nIndex];
                nIndex++;
            }

            currentIndex++;
        }
        while (mIndex < m) {
            holder[currentIndex] = nums1[mIndex];
            mIndex++;
            currentIndex++;
        }

        while (nIndex < n) {
            holder[currentIndex] = nums2[nIndex];
            nIndex++;
            currentIndex++;
        }

        int mid = holder.length / 2;
        if ((m + n) % 2 == 0) {
            return (double)((holder[mid] + holder[mid - 1]) / 2d);
        }
        return holder[mid];
    }

}
