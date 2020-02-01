package com.mikalai.algo.context.flow;

import com.mikalai.algo.graph.shortpath.DirectedEdge;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class FlowNetwork {
    private final int vertexCount;
    private int edgeCount;
    private Set<FlowEdge>[] adj;

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public FlowNetwork(int v) {
        this.vertexCount = v;
        this.edgeCount = 0;
        adj = (Set<FlowEdge>[]) new Set[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adj[i] = new LinkedHashSet<FlowEdge>();

        }
    }

    public void addEdge(FlowEdge e) {
        adj[e.getFrom()].add(e);
        adj[e.getTo()].add(e);
        edgeCount++;
    }

    public Iterable<FlowEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<FlowEdge> edges() {
        Set<FlowEdge> b = new LinkedHashSet<FlowEdge>();
        for (int v = 0; v < vertexCount; v++) {
            for (FlowEdge e : adj[v]) {
                b.add(e);

            }
        }

        return b;
    }

    @Override
    public String toString() {
        return "FlowNetwork{" +
            "vertexCount=" + vertexCount +
            ", edgeCount=" + edgeCount +
            ", adj=" + Arrays.toString(adj) +
            '}';
    }
}
