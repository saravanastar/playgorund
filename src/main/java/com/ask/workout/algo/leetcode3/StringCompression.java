package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/string-compression
 */
public class StringCompression {

    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        System.out.println(stringCompression.compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(stringCompression.compress(new char[]{'a'}));
        System.out.println(stringCompression.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }
    public int compress(char[] chars) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = chars.length;
        int currentIndex = 0;
        int totalLength = 0;
        while (currentIndex < n) {
            int dupLength = 0;
            int dupIndex = currentIndex;
            char fixedChar = chars[currentIndex];
            while (dupIndex < n && fixedChar == chars[dupIndex]) {
                dupLength++;
                dupIndex++;
            }
            stringBuilder.append(fixedChar);
            if (dupLength == 1) {
                totalLength+=dupLength;
            } else {
                int length = String.valueOf(dupLength).length();
                stringBuilder.append(String.valueOf(dupLength));
                totalLength+=length+1;
            }
            currentIndex+=dupLength;
        }
        for (int index = 0; index < stringBuilder.length(); index++) {
            chars[index] = stringBuilder.charAt(index);
        }

        return totalLength;
    }
}
