package com.mikalai.leetcode.regexp;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static boolean isMatch(String s, String p) {
        DirectedGraph directedGraph = buildPattern(p);
        Set<Integer> startPositions = Collections.singleton(0);

        DepthFirstSearch dfs = new DepthFirstSearch(directedGraph, startPositions);
        Set<Integer> reachedStates = dfs.reachedVertexes();

        char[] strToCheck = s.toCharArray();

        for (int i = 0; i < strToCheck.length; i++) {
            startPositions = new HashSet<>();
            for (Integer statePosition : reachedStates) {
                if (statePosition < p.length()) {
                    if (p.charAt(statePosition) == '.' || strToCheck[i] == p.charAt(statePosition)) {
                        startPositions.add(statePosition + 1);
                    }
                }

            }

            dfs = new DepthFirstSearch(directedGraph, startPositions);
            reachedStates = dfs.reachedVertexes();

        }

        // reached last finish state
        return reachedStates.contains(p.length());
    }

    private static DirectedGraph buildPattern(final String p) {
        int vertexCount = p.length() + 1;
        DirectedGraph dg = new DirectedGraph(vertexCount);
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                if (i > 0) {
                    dg.addEdge(i, i - 1);
                    dg.addEdge(i -1, i);
                }

                if (i < vertexCount - 1) {
                    dg.addEdge(i, i + 1);
                }
            }

        }

        return dg;
    }


}
