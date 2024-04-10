package com.ask.workout.algo.leetcode3;


import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board1 = 
{{'5','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};

        char[][] board2 =
                {{'8','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};
        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(board1));
        System.out.println(validSudoku.isValidSudoku(board2));
    }

    public boolean isValidSudoku(char[][] board) {
        return checkRowWise(board) && checkColumnWise(board) && checkSubSquare(board);
    }

    private boolean checkSubSquare(char[][] board) {
        for (int rowBound = 0; rowBound < board.length; rowBound = rowBound+3) {
            for (int columnBound = 0; columnBound < board[0].length; columnBound = columnBound+3) {
                Set<Character> lookup = new HashSet<>();
                for (int row = rowBound; row < rowBound + 3; row++) {
                    for (int column = columnBound; column < columnBound + 3; column++) {
                        Character currentChar = board[row][column];
                        if (currentChar != '.') {
                            if (lookup.contains(currentChar)) {
                                return false;
                            }
                            lookup.add(currentChar);
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean checkColumnWise(char[][] board) {

        for (int column = 0; column < board[0].length; column++) {
            Set<Character> lookup = new HashSet<>();
            for (int row = 0; row < board.length; row++) {
                Character currentChar = board[row][column];
                if (currentChar != '.') {
                    if (lookup.contains(currentChar)) {
                        return false;
                    }
                    lookup.add(currentChar);
                }
            }
        }
        return true;
    }

    private boolean checkRowWise(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            Set<Character> lookup = new HashSet<>();
            for (int column = 0; column < board[row].length; column++) {
                Character currentChar = board[row][column];
                if (currentChar != '.') {
                    if (lookup.contains(currentChar)) {
                        return false;
                    }
                    lookup.add(currentChar);
                }
            }
        }
        return true;
    }
}
