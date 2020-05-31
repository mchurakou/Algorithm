package com.mikalai.algo.graph.shortpath;

import java.util.Arrays;

public class FloydWarshalShortPathLength {
    public int[][] calculateShortPat(int[][] graph) {


        for (int k = 0; k < graph.length; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if (graph[i][k] != 0 && graph[k][j] != 0) {
                        if (graph[i][j] != 0) {
                            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        } else {
                            graph[i][j] = graph[i][k] + graph[k][j];
                        }


                    }
                }
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        FloydWarshalShortPathLength f = new FloydWarshalShortPathLength();
        System.out.println(Arrays.deepToString(f.calculateShortPat(new int[][]{
            {0, 1, 0, 11},
            {0, 0, 2, 5},
            {0, 0, 0, 1},
            {0, 0, 0, 0},
        })));
    }
}
