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
        char[][] inValidTictocDiagonal = new char[][]{
                {'R', ' ', ' ', ' '},
                {' ', ' ', 'Y', 'R'},
                {' ', ' ', 'R', 'R'},
                {' ', ' ', ' ', 'R'}};

        TicTac ticTac = new TicTac();
        System.out.println("Valid Horizontal: ===> " + ticTac.isValid(validTictocHorizontal, 0, 0, 'R'));
        System.out.println("InValid Horizontal: ===> " + !ticTac.isValid(invalidTictocHorizontal, 0, 0, 'R'));
        System.out.println("valid vertical: ===> " + ticTac.isValid(validTictocVertical, 3, 3, 'R'));
        System.out.println("invalid vertical: ===> " + !ticTac.isValid(invalidTictocVertical, 3, 3, 'R'));
        System.out.println("valid diagonal: ===> " + ticTac.isValid(validTictocDiagonal, 3, 3, 'R'));
        System.out.println("invalid diagonal: ===> " + !ticTac.isValid(inValidTictocDiagonal, 3, 3, 'R'));
    }

    private static boolean isOutOfBound(char[][] input, int row, int column) {
        return (row < 0 || row >= input.length) || (column < 0 || column >= input[0].length);
    }

    public boolean isValid(char[][] input, int lastPointRow, int lastPointColumn, char characterToCheck) {
        return isValidDiagonal(input, lastPointRow, lastPointColumn, TOTAL_LENGTH_TO_CHECK, characterToCheck) ||
                isValidHorizontal(input, lastPointRow, lastPointColumn, TOTAL_LENGTH_TO_CHECK, characterToCheck) ||
                isValidVertical(input, lastPointRow, lastPointColumn, TOTAL_LENGTH_TO_CHECK, characterToCheck);
    }

    private boolean isValidHorizontal(char[][] input, int row, int column, int totalLengthToCheck, char characterToCheck) {

        return isValidHorizontalBackward(input, row, column, totalLengthToCheck, characterToCheck) || isValidHorizontalForward(input, row, column, totalLengthToCheck, characterToCheck);
    }

    private boolean isValidHorizontalForward(char[][] input, int row, int column, int totalLengthToCheck, char characterToCheck) {
        if (isOutOfBound(input, row, column)) return false;
        if (input[row][column] != characterToCheck) return false;
        if (totalLengthToCheck - 1 == 0) {
            return true;
        }
        return isValidHorizontalForward(input, row, column + 1, totalLengthToCheck - 1, characterToCheck);
    }

    private boolean isValidHorizontalBackward(char[][] input, int row, int column, int totalLengthToCheck, char characterToCheck) {
        if (isOutOfBound(input, row, column)) return false;
        if (input[row][column] != characterToCheck) return false;
        if (totalLengthToCheck - 1 == 0) {
            return true;
        }
        return isValidHorizontalBackward(input, row, column - 1, totalLengthToCheck - 1, characterToCheck);
    }

    private boolean isValidVertical(char[][] input, int row, int column, int totalLengthToCheck, char characterToCheck) {


        return isVerticalDownMatch(input, row, column, totalLengthToCheck, characterToCheck) || isVerticalUpMatch(input, row, column, totalLengthToCheck, characterToCheck);
    }

    private boolean isVerticalUpMatch(char[][] input, int row, int column, int totalLengthToCheck, char characterToCheck) {
        if (isOutOfBound(input, row, column)) return false;
        if (input[row][column] != characterToCheck) return false;
        if (totalLengthToCheck - 1 == 0) {
            return true;
        }
        return isVerticalUpMatch(input, row - 1, column, totalLengthToCheck - 1, characterToCheck);
    }

    private boolean isVerticalDownMatch(char[][] input, int row, int column, int totalLengthToCheck, char characterToCheck) {
        if (isOutOfBound(input, row, column)) return false;
        if (input[row][column] != characterToCheck) return false;
        if (totalLengthToCheck - 1 == 0) {
            return true;
        }
        return isVerticalDownMatch(input, row + 1, column, totalLengthToCheck - 1, characterToCheck);
    }

    private boolean isValidDiagonal(char[][] input, int row, int column, int totalLengthToCheck, char characterToCheck) {


        return isValidDiagonalFromTopLeft(input, row, column, totalLengthToCheck, characterToCheck) || isValidDiagonalFromBottomRight(input, row, column, totalLengthToCheck, characterToCheck);
    }

    private boolean isValidDiagonalFromBottomRight(char[][] input, int row, int column, int totalLengthToCheck, char characterToCheck) {
        if (isOutOfBound(input, row, column)) return false;
        if (input[row][column] != characterToCheck) return false;
        if (totalLengthToCheck - 1 == 0) {
            return true;
        }
        return isValidDiagonalFromBottomRight(input, row + 1, column + 1, totalLengthToCheck - 1, characterToCheck);
    }

    private boolean isValidDiagonalFromTopLeft(char[][] input, int row, int column, int totalLengthToCheck, char characterToCheck) {
        if (isOutOfBound(input, row, column)) return false;
        if (input[row][column] != characterToCheck) return false;
        if (totalLengthToCheck - 1 == 0) {
            return true;
        }
        return isValidDiagonalFromTopLeft(input, row - 1, column - 1, totalLengthToCheck - 1, characterToCheck);
    }


}
