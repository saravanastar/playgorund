package com.ask.workout.algo.leetcode;

public class FindSmallestGreaterThanTarget {

    public static void main(String[] args) {
        FindSmallestGreaterThanTarget findSmallestGreaterThanTarget = new FindSmallestGreaterThanTarget();
        System.out.println(findSmallestGreaterThanTarget.nextGreatestLetter(new char[]{'c','f','j'}, 'a'));
        System.out.println(findSmallestGreaterThanTarget.nextGreatestLetter(new char[]{'c','f','j'}, 'c'));
        System.out.println(findSmallestGreaterThanTarget.nextGreatestLetter(new char[]{'x','x','y','y'}, 'z'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length-1;
        while(left+1 < right) {
            int mid = left + (right-left)/2;
            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (letters[left] > target) {
            return letters[left];
        } else if (letters[right] > target) {
            return letters[right];
        }
        return letters[0];
    }
}
