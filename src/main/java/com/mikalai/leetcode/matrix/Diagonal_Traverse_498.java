package com.mikalai.leetcode.matrix;

import java.util.Arrays;

public class Diagonal_Traverse_498 {

    public int[] findDiagonalOrder(int[][] matrix) {
        int rawCount = matrix.length;
        if (rawCount == 0) {
            return new int[0];
        }

        int columnCount = matrix[0].length;

        int positionRaw = 0;
        int positionColumn = 0;

        boolean directionUp = true;

        int[] result = new int[rawCount * columnCount];
        int resultIndex = 0;

        while (!(positionRaw == rawCount - 1 && positionColumn == columnCount - 1)) {
            result[resultIndex++] = matrix[positionRaw][positionColumn];

            if (directionUp) {
                positionRaw--;
                positionColumn++;
                if (positionRaw < 0 || positionColumn == columnCount) {
                    directionUp = false;

                    if (positionColumn == columnCount) {
                        positionColumn--;
                        positionRaw += 2;
                    } else {
                        positionRaw = 0;
                    }

                }
            } else {
                positionColumn--;
                positionRaw++;

                if (positionColumn < 0 || positionRaw == rawCount) {
                    directionUp = true;

                    if (positionRaw == rawCount) {
                        positionRaw--;
                        positionColumn += 2;
                    } else {
                        positionColumn = 0;
                    }

                }
            }

        }

        result[resultIndex] = matrix[positionRaw][positionColumn];

        return result;
    }

    public static void main(String[] args) {
        Diagonal_Traverse_498 d = new Diagonal_Traverse_498();
        System.out.println(Arrays.toString(d.findDiagonalOrder(new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        })));
    }
}
