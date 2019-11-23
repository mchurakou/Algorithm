package com.mikalai.leetcode.regexp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DepthFirstSearch {
    private boolean[] marked;

    public DepthFirstSearch(final DirectedGraph directedGraph, final Set<Integer> starts) {
        this.marked = new boolean[directedGraph.getVertexCount()];

        for (Integer start : starts) {
            dfs(directedGraph, start);
        }
    }

    private void dfs(final DirectedGraph directedGraph, final Integer start) {
        marked[start] = true;
        for (Integer v : directedGraph.getReachedVertexes(start)) {
            if (!marked[v]) {
                dfs(directedGraph, v);
            }
        }

    }

    public boolean hasPathTo(int to) {
        return marked[to];
    }

    public Set<Integer> reachedVertexes() {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < marked.length; i++) {
            if (marked[i]) {
                result.add(i);
            }
        }

        return result;

    }

    @Override
    public String toString() {
        return "DepthFirstSearch{" +
            "marked=" + Arrays.toString(marked) +
            '}';
    }
}
