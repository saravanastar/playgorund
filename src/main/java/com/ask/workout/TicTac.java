package com.ask.workout;

public class TicTac {

    public static final int TOTAL_LENGTH_TO_CHECK = 4;

    public static void main(String[] args) {
        char[][] validTictocHorizontal = new char[][]{
                {'R', 'R', 'R', 'R'},
                {'R', 'R', 'Y', 'Y'},
                {' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' '}};
        char[][] invalidTictocHorizontal = new char[][]{
                {'R', ' ', 'R', 'R'},
                {' ', ' ', 'Y', 'Y'},
                {' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' '}};

        char[][] validTictocVertical = new char[][]{
                {' ', ' ', ' ', 'R'},
                {' ', ' ', 'Y', 'R'},
                {' ', ' ', ' ', 'R'},
                {' ', ' ', ' ', 'R'}};
        char[][] invalidTictocVertical = new char[][]{
                {' ', ' ', ' ', ' '},
                {' ', ' ', 'Y', 'R'},
                {' ', ' ', ' ', 'R'},
                {' ', ' ', ' ', 'R'}};

        char[][] validTictocDiagonal = new char[][]{
                {'R', ' ', ' ', ' '},
                {' ', 'R', 'Y', 'R'},
                {' ', ' ', 'R', 'R'},
                {' ', ' ', ' ', 'R'}};

        char[][] validTictocDiagonal2 = new char[][]{
                {' ', ' ', ' ', 'R'},
                {' ', 'R', 'R', 'R'},
                {' ', 'R', 'R', 'R'},
                {'R', ' ', ' ', 'R'}};
        char[][] inValidTictocDiagonal = new char[][]{
                {'R', ' ', ' ', ' '},
                {' ', ' ', 'Y', 'R'},
                {' ', ' ', 'R', 'R'},
                {' ', ' ', ' ', 'R'}};

        TicTac ticTac = new TicTac();
        System.out.println("Valid Horizontal: ===> " + ticTac.isValid(validTictocHorizontal, 0, 2, 'R'));
        System.out.println("InValid Horizontal: ===> " + !ticTac.isValid(invalidTictocHorizontal, 0, 2, 'R'));
        System.out.println("valid vertical: ===> " + ticTac.isValid(validTictocVertical, 3, 3, 'R'));
        System.out.println("invalid vertical: ===> " + !ticTac.isValid(invalidTictocVertical, 3, 3, 'R'));
        System.out.println("valid diagonal: ===> " + ticTac.isValid(validTictocDiagonal, 1, 1, 'R'));
        System.out.println("valid diagonal: ===> " + ticTac.isValid(validTictocDiagonal2, 3, 0, 'R'));
        System.out.println("invalid diagonal: ===> " + !ticTac.isValid(inValidTictocDiagonal, 3, 3, 'R'));
    }

    private static boolean isOutOfBound(char[][] input, int row, int column) {
        return (row < 0 || row >= input.length) || (column < 0 || column >= input[0].length);
    }

    public boolean isValid(char[][] input, int lastPointRow, int lastPointColumn, char characterToCheck) {
        return isValidDiagonal(input, lastPointRow, lastPointColumn, characterToCheck) ||
                isValidHorizontal(input, lastPointRow, lastPointColumn, characterToCheck) ||
                isValidVertical(input, lastPointRow, lastPointColumn, characterToCheck);
    }

    private boolean isValidHorizontal(char[][] input, int row, int column, char characterToCheck) {
        //if out of bound or character not matches return false immediately
        if (isOutOfBound(input, row, column) || input[row][column] != characterToCheck) return false;
        // if total matches greater than equal 4 return true.
        return (1 + matchFoundHorizontalBackward(input, row, column-1, 0, characterToCheck) + matchFoundHorizontalForward(input, row, column+1, 0, characterToCheck)) >= TOTAL_LENGTH_TO_CHECK;
    }

    private int matchFoundHorizontalForward(char[][] input, int row, int column, int currentMatchedCharacterLength, char characterToCheck) {
        //if out of bound or character not matches return the matched count
        //otherwise continue forward recursive function
        if (isOutOfBound(input, row, column)) return currentMatchedCharacterLength;
        if (input[row][column] != characterToCheck) return currentMatchedCharacterLength;
        currentMatchedCharacterLength = currentMatchedCharacterLength + 1;
        return matchFoundHorizontalForward(input, row, column + 1, currentMatchedCharacterLength, characterToCheck);
    }

    private int matchFoundHorizontalBackward(char[][] input, int row, int column, int currentMatchedCharacterLength, char characterToCheck) {
        //if out of bound or character not matches return the matched count
        //otherwise continue forward recursive function
        if (isOutOfBound(input, row, column)) return currentMatchedCharacterLength;
        if (input[row][column] != characterToCheck) return currentMatchedCharacterLength;
        currentMatchedCharacterLength = currentMatchedCharacterLength + 1;
        return matchFoundHorizontalBackward(input, row, column - 1, currentMatchedCharacterLength, characterToCheck);
    }

    private boolean isValidVertical(char[][] input, int row, int column, char characterToCheck) {
        //if out of bound or character not matches return false immediately
        if (isOutOfBound(input, row, column) || input[row][column] != characterToCheck) return false;
        return (1 + matchVerticalDown(input, row+1, column, 0, characterToCheck) + matchVerticalUp(input, row-1, column, 0, characterToCheck)) >= TOTAL_LENGTH_TO_CHECK;
    }

    private int matchVerticalUp(char[][] input, int row, int column, int currentMatchedCharacterLength, char characterToCheck) {
        //if out of bound or character not matches return the matched count
        //otherwise continue forward recursive function
        if (isOutOfBound(input, row, column)) return currentMatchedCharacterLength;
        if (input[row][column] != characterToCheck) return currentMatchedCharacterLength;
        currentMatchedCharacterLength = currentMatchedCharacterLength + 1;
        return matchVerticalUp(input, row-1, column, currentMatchedCharacterLength, characterToCheck);
    }

    private int matchVerticalDown(char[][] input, int row, int column, int currentMatchedCharacterLength, char characterToCheck) {
        //if out of bound or character not matches return the matched count
        //otherwise continue forward recursive function
        if (isOutOfBound(input, row, column)) return currentMatchedCharacterLength;
        if (input[row][column] != characterToCheck) return currentMatchedCharacterLength;
        currentMatchedCharacterLength = currentMatchedCharacterLength + 1;
        return matchVerticalDown(input, row + 1, column, currentMatchedCharacterLength, characterToCheck);
    }

    private boolean isValidDiagonal(char[][] input, int row, int column, char characterToCheck) {
        //if out of bound or character not matches return false immediately
        if (isOutOfBound(input, row, column) || input[row][column] != characterToCheck) return false;
        return ((1 + matchFoundTopLeft(input, row-1, column-1, 0, characterToCheck) + matchFoundBottomRight(input, row+1, column+1, 0, characterToCheck)) >= TOTAL_LENGTH_TO_CHECK ||
                (1 + matchFoundTopRight(input, row-1, column+1, 0, characterToCheck) + matchFoundBottomLeft(input, row+1, column - 1, 0, characterToCheck)) >= TOTAL_LENGTH_TO_CHECK);
    }

    private int matchFoundBottomRight(char[][] input, int row, int column, int currentMatchedCharacterLength, char characterToCheck) {
        //if out of bound or character not matches return the matched count
        //otherwise continue forward recursive function
        if (isOutOfBound(input, row, column)) return currentMatchedCharacterLength;
        if (input[row][column] != characterToCheck) return currentMatchedCharacterLength;
        currentMatchedCharacterLength = currentMatchedCharacterLength + 1;
        return matchFoundBottomRight(input, row + 1, column + 1, currentMatchedCharacterLength, characterToCheck);
    }

    private int matchFoundTopLeft(char[][] input, int row, int column, int currentMatchedCharacterLength, char characterToCheck) {
        //if out of bound or character not matches return the matched count
        //otherwise continue forward recursive function
        if (isOutOfBound(input, row, column)) return currentMatchedCharacterLength;
        if (input[row][column] != characterToCheck) return currentMatchedCharacterLength;
        currentMatchedCharacterLength = currentMatchedCharacterLength + 1;
        return matchFoundTopLeft(input, row - 1, column - 1, currentMatchedCharacterLength, characterToCheck);
    }


    private int matchFoundTopRight(char[][] input, int row, int column, int currentMatchedCharacterLength, char characterToCheck) {
        //if out of bound or character not matches return the matched count
        //otherwise continue forward recursive function
        if (isOutOfBound(input, row, column)) return currentMatchedCharacterLength;
        if (input[row][column] != characterToCheck) return currentMatchedCharacterLength;
        currentMatchedCharacterLength = currentMatchedCharacterLength + 1;
        return matchFoundTopRight(input, row - 1, column + 1, currentMatchedCharacterLength, characterToCheck);
    }


    private int matchFoundBottomLeft(char[][] input, int row, int column, int currentMatchedCharacterLength, char characterToCheck) {
        //if out of bound or character not matches return the matched count
        //otherwise continue forward recursive function
        if (isOutOfBound(input, row, column)) return currentMatchedCharacterLength;
        if (input[row][column] != characterToCheck) return currentMatchedCharacterLength;
        currentMatchedCharacterLength = currentMatchedCharacterLength + 1;
        return matchFoundBottomLeft(input, row + 1, column - 1, currentMatchedCharacterLength, characterToCheck);
    }
}
