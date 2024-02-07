package com.ask.workout.algo.leetcode2;

/**
 * https://leetcode.com/problems/flood-fill/
 */
public class FloodFill {

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
//        int[][] input1 = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
//        int[][] output1 = floodFill.floodFill(input1,1, 1, 2);
//        print(output1);

        int[][] input2 = new int[][]{{0,0,0},{0,0,0}};
        int[][] output2 = floodFill.floodFill(input2,0, 0, 0);
        print(output2);

    }

    private static void print(int[][] output1) {
        for (int i = 0; i < output1.length; i++) {
            for (int j = 0; j < output1[i].length; j++) {
                System.out.print(output1[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int replaceColorCode = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        fill(image, sr, sc, color, replaceColorCode, visited);
        return image;
    }

    private void fill(int[][] image, int positionI, int positionJ, int color, int replaceColorCode, boolean[][] visited ) {
        if (positionI < image.length && positionI >= 0 && positionJ < image[0].length && positionJ >=0 && !visited[positionI][positionJ]) {
            if (image[positionI][positionJ] == replaceColorCode) {
                image[positionI][positionJ] = color;
                visited[positionI][positionJ] = true;
                fill(image, positionI-1, positionJ, color, replaceColorCode, visited);
                fill(image, positionI+1, positionJ, color, replaceColorCode, visited);
                fill(image, positionI, positionJ-1, color, replaceColorCode, visited);
                fill(image, positionI, positionJ+1, color, replaceColorCode, visited);
            }
        }

    }

}
