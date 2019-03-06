package com.mikalai.algo.graph.undirected;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by mikalai on 28.06.2015.
 */
public class Graph {

    private final int vertexCount;
    private int edgeCount;
    private Set<Integer>[] adj;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        this.edgeCount = 0;

        adj = (Set<Integer>[]) new Set[this.vertexCount];

        for (int i = 0; i < this.vertexCount; i++) {
            adj[i] = new LinkedHashSet<>();

        }

    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        edgeCount++;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public Iterable<Integer> adjacentVertexes(int vertex) {
        return adj[vertex];
    }

}
