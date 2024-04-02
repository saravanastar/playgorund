package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/number-of-islands/description/
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        char[][] input1 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] input2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        char[][] input3 = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        System.out.println(numberOfIslands.numIslands(input3));
//        System.out.println(numberOfIslands.numIslands(input1));
//        System.out.println(numberOfIslands.numIslands(input2));
    }

    public int numIslands(char[][] grid) {
        int totalRow = grid.length;
        int totalColumn = grid[0].length;
        int row = 0;
        int column = 0;
        boolean[][] visited = new boolean[totalRow][totalColumn];
        int result = 0;
        while (row < totalRow) {
            column = 0;
            while (column < totalColumn) {
                if (grid[row][column] == '1') {
                    result += 1;
                    numIslands(grid, row, column);
                }
                column++;
            }
            row++;

        }
        return result;
    }

    public void numIslands(char[][] grid, int row, int column) {
        if(isOutOfBound(grid, row, column) || grid[row][column] == '0') {
            return;
        }
        grid[row][column] = '0';
        numIslands(grid, row +1, column);
        numIslands(grid, row, column + 1);
        numIslands(grid, row, column - 1);
        numIslands(grid, row -1, column);
    }

    public boolean isOutOfBound(char[][] grid, int row, int column) {
        if(row < 0 || row >= grid.length) {
            return true;
        }
        if(column < 0 || column >= grid[0].length) {
            return true;
        }
        return false;
    }
}
