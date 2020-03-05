package com.mikalai.amazon.asmt.one;

import com.mikalai.algo.unionfind.WeightedUnionUF;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MatrixCluster {
    public static void main(String[] args) {

        System.out.println("Brute force");

        System.out.println(numberAmazonTreasureTrucks(5,4 , Arrays.asList(
            Arrays.asList(1,1,0,0),
            Arrays.asList(0,0, 1,0),
            Arrays.asList(0,0, 0,0),
            Arrays.asList(1,0, 1,1),
            Arrays.asList(1,1, 1,1))));

        System.out.println(numberAmazonTreasureTrucks(4,4 , Arrays.asList(
            Arrays.asList(1,1,0,0),
            Arrays.asList(0,0, 0,0),
            Arrays.asList(0,0, 1,1),
            Arrays.asList(0,0, 0,0))));

        System.out.println(numberAmazonTreasureTrucks(7,7 , Arrays.asList(
            Arrays.asList(1,0,0,0,0,0,0),
            Arrays.asList(0,1,0,0,0,0,0),
            Arrays.asList(0,0,1,0,0,0,0),
            Arrays.asList(0,0,0,1,0,0,0),
            Arrays.asList(0,0,0,0,1,0,0),
            Arrays.asList(0,0,0,0,0,1,0),
            Arrays.asList(0,0,0,0,0,0,1))));

        System.out.println("UF");

        System.out.println(numberAmazonTreasureTrucksUF(5,4 , Arrays.asList(
            Arrays.asList(1,1,0,0),
            Arrays.asList(0,0, 1,0),
            Arrays.asList(0,0, 0,0),
            Arrays.asList(1,0, 1,1),
            Arrays.asList(1,1, 1,1))));

        System.out.println(numberAmazonTreasureTrucksUF(4,4 , Arrays.asList(
            Arrays.asList(1,1,0,0),
            Arrays.asList(0,0, 0,0),
            Arrays.asList(0,0, 1,1),
            Arrays.asList(0,0, 0,0))));

        System.out.println(numberAmazonTreasureTrucksUF(7,7 , Arrays.asList(
            Arrays.asList(1,0,0,0,0,0,0),
            Arrays.asList(0,1,0,0,0,0,0),
            Arrays.asList(0,0,1,0,0,0,0),
            Arrays.asList(0,0,0,1,0,0,0),
            Arrays.asList(0,0,0,0,1,0,0),
            Arrays.asList(0,0,0,0,0,1,0),
            Arrays.asList(0,0,0,0,0,0,1))));


    }

    static int numberAmazonTreasureTrucks(int rows, int column,
                                   List<List<Integer>> grid)

    {
        boolean[][] marked = new boolean[rows][column];

        int clusterCount = 0;


        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < column; i++) {
                if (!marked[j][i] && grid.get(j).get(i) == 1) {
                    clusterTraverse(j, i, marked, grid);
                    clusterCount++;
                }
            }
        }

        return clusterCount;
    }

    static int numberAmazonTreasureTrucksUF(int rows, int column,
                                          List<List<Integer>> grid)

    {

        WeightedUnionUF uf = new WeightedUnionUF(rows * column);

        int countOfZero = 0;

        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < column; i++) {
                if (grid.get(j).get(i) == 1) {

                    if (i > 0 && grid.get(j).get(i - 1) == 1)
                        uf.union((j * column + i), (j * column + i - 1) );

                    if (i < column - 1 && grid.get(j).get(i + 1) == 1)
                        uf.union((j * column + i), (j * column + i + 1) );

                    if (j > 0 && grid.get(j - 1).get(i) == 1)
                        uf.union((j * column + i), ((j - 1)  * column + i) );

                    if (j < rows - 1 && grid.get(j + 1).get(i) == 1)
                        uf.union((j * column + i), ((j + 1) * column + i));
                } else {
                    countOfZero++;
                }
            }
        }

        return uf.count() - countOfZero;
    }
    private static void clusterTraverse(final int j, final int i, final boolean[][] marked, final List<List<Integer>> grid) {
        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry<>(j, i));

        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> pair = queue.poll();
            Integer row = pair.getKey();
            Integer column = pair.getValue();
            marked[row][column] = true;

            if (row > 0 && grid.get(row - 1).get(column) == 1 && !marked[row - 1][column]) {
                queue.add(new AbstractMap.SimpleEntry<>(row - 1, column));
            }

            if (row < grid.size() - 1 && grid.get(row + 1).get(column) == 1  && !marked[row + 1][column]) {
                queue.add(new AbstractMap.SimpleEntry<>(row + 1, column));
            }

            if (column > 0 && grid.get(row).get(column - 1) == 1 && !marked[row ][column - 1]) {
                queue.add(new AbstractMap.SimpleEntry<>(row, column - 1));
            }

            if (column < grid.get(row).size() - 1 && grid.get(row).get(column + 1) == 1 && !marked[row][column + 1]) {
                queue.add(new AbstractMap.SimpleEntry<>(row, column + 1));
            }

        }
    }
}
