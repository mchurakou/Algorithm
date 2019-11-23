package com.mikalai.leetcode.regexp;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class DirectedGraph {

    private final int vertexCount;
    private final Set<Integer>[] graph;

    private int edgeCount;

    public DirectedGraph(final int vertexCount) {
        this.vertexCount = vertexCount;
        graph = (Set<Integer>[]) new LinkedHashSet[vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            graph[i] = new LinkedHashSet<>();

        }
    }

    public void addEdge(int from, int to) {
        if (!graph[from].contains(to)) {
            graph[from].add(to);
            edgeCount++;
        }
    }

    public Set<Integer> getReachedVertexes(int from) {
        return graph[from];
    }

    public int getVertexCount() {
        return vertexCount;
    }

    @Override
    public String toString() {
        return "DirectedGraph{" +
            "vertexCount=" + vertexCount +
            ", graph=" + Arrays.toString(graph) +
            ", edgeCount=" + edgeCount +
            '}';
    }
}
