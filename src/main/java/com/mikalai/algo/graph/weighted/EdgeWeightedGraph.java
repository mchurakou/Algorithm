package com.mikalai.algo.graph.weighted;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by mikalai on 06.09.2015.
 */
public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private Set<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (Set<Edge>[]) new Set[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedHashSet<Edge>();

        }
    }

    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        Set<Edge> b = new LinkedHashSet<>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj[v]) {
                if (e.other(v) > v)
                    b.add(e);

            }
        }

        return b;
    }
}


