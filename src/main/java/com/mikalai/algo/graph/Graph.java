package com.mikalai.algo.graph;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by mikalai on 28.06.2015.
 */
public class Graph {

    private final int V;
    private int E;
    private Set<Integer>[] adj;

    public Graph(int v) {
        V = v;
        this.E = 0;

        adj = (Set<Integer>[]) new Set[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedHashSet<Integer>();

        }

    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

}
