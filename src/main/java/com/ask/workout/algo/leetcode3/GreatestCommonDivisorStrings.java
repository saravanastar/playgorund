package com.ask.workout.algo.leetcode3;

import java.util.Objects;

/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/description
 */
public class GreatestCommonDivisorStrings {

    public static void main(String[] args) {
        GreatestCommonDivisorStrings greatestCommonDivisorStrings = new GreatestCommonDivisorStrings();
        System.out.println(greatestCommonDivisorStrings.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(greatestCommonDivisorStrings.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(greatestCommonDivisorStrings.gcdOfStrings("LEET", "CODE"));
    }

    public String gcdOfStrings(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();

        int minLength = Math.min(length1, length2);

        for (int len = minLength; len > 0; len--) {
            if (isDivisible(len, str1, str2)) {
                return str1.substring(0, len);
            }
        }
        return "";
    }

    private boolean isDivisible(int len, String string1, String string2) {
        if (string1.length()%len != 0 || string2.length() % len != 0) {
            return false;
        }
        int factor1 = string1.length()/len;
        int factor2 = string2.length()/len;
        return Objects.equals(concatenateCopy(string1.substring(0, len), factor1), string1) && Objects.equals(concatenateCopy(string1.substring(0, len), factor2), string2);
    }

    private String concatenateCopy(String string, int times) {
        StringBuilder stringBuilder = new StringBuilder();
        while (times > 0) {
            stringBuilder.append(string);
            times--;
        }
        return stringBuilder.toString();
    }
}
