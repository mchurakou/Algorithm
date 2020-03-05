package com.mikalai.amazon.asmt.two;

import java.util.Arrays;
import java.util.List;

public class ServerUpdate {
    public static void main(String[] args) {

        System.out.println(minimumDays(4,5 , Arrays.asList(
            Arrays.asList(0,1,1,0,1),
            Arrays.asList(0,1,0,1,0),
            Arrays.asList(0,0,0,0,1),
            Arrays.asList(0,1,0,0,0))));

        System.out.println(minimumDays(1,1 , Arrays.asList(
            Arrays.asList(0))));

        System.out.println(minimumDays(5,5 , Arrays.asList(
            Arrays.asList(1,0,0,0,0),
            Arrays.asList(0,1,0,0,0),
            Arrays.asList(0,0,1,0,0),
            Arrays.asList(0,0,0,1,0),
            Arrays.asList(0,0,0,0,1))));

        System.out.println(minimumDays(5,6 , Arrays.asList(
            Arrays.asList(0,0,1,0,0,0),
            Arrays.asList(0,0,0,0,0,0),
            Arrays.asList(0,0,0,0,0,1),
            Arrays.asList(0,0,0,0,0,0),
            Arrays.asList(0,1,0,0,0,0))));

    }

    static int  minimumDays(int rows, int columns, List<java.util.List<Integer> > grid)
    {
        int countOfDay = 0;
        int countOfNewUpdateServer = 0;

        boolean[][] alreadyUpdatedServer = new boolean[rows][columns];
        int alreadyUpdatedServerCount = 0;

        do {

            countOfNewUpdateServer = 0;
            int[][] newUpdatedServer = new int[rows][columns];
            for (int j = 0; j < rows; j++) {
                for (int i = 0; i < columns; i++) {
                    if (!alreadyUpdatedServer[j][i] && grid.get(j).get(i) == 1) {
                        alreadyUpdatedServer[j][i] = true;
                        alreadyUpdatedServerCount++;

                        if (j > 0 && grid.get(j - 1).get(i) == 0 && !alreadyUpdatedServer[j - 1][i] ) {
                            newUpdatedServer[j-1][i] = 1;
                        }

                        if (j < grid.size() - 1 && grid.get(j + 1).get(i) == 0 && !alreadyUpdatedServer[j + 1][i]) {
                            newUpdatedServer[j+1][i] = 1;
                        }

                        if (i > 0 && grid.get(j).get(i - 1) == 0 && !alreadyUpdatedServer[j][i - 1]) {
                            newUpdatedServer[j][i-1] = 1;
                        }

                        if (i < grid.get(j).size() - 1 && grid.get(j).get(i + 1) == 0 && !alreadyUpdatedServer[j][i + 1]) {
                            newUpdatedServer[j][i+1] = 1;
                        }
                    }
                }
            }

            for (int j = 0; j < rows; j++) {
                for (int i = 0; i < columns; i++) {
                    if (newUpdatedServer[j][i] == 1) {
                        countOfNewUpdateServer++;
                        grid.get(j).set(i, 1);
                    }
                }
            }

            if (countOfNewUpdateServer > 0) {
                countOfDay++;
            }
        } while (countOfNewUpdateServer > 0);

        if (alreadyUpdatedServerCount != rows * columns) {
            return -1;
        } else {
            return countOfDay;
        }

    }
}
