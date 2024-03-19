package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/description/
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
        System.out.println(excelSheetColumnNumber.titleToNumber("AA"));
    }

    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int power = 0;
        int currentIndex = columnTitle.length()-1;
        int sum = 0;
        while (currentIndex>=0) {
            int currentPosition = chars[currentIndex] - 'A';
            sum = sum + (int)Math.pow(26, power++) * currentPosition;
            currentIndex--;
        }
        return sum;
    }

    /**
     *
     * A B
     * 0 * 26 +position = 2
     * 1*26 * position = 26
     * 1*26*26
     *
     *
     * AAA
     *
     * 2*26*1 = 52+26+1
     */
}
