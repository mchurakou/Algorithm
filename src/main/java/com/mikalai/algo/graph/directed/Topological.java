package com.mikalai.algo.graph.directed;

import com.mikalai.algo.graph.shortpath.EdgeWeightedDigraph;

import java.util.Deque;

/**
 * Created by mikalai on 23.08.2015.
 */
public class Topological {
    public Deque<Integer> order;

    public Topological(Digraph G) {
        DirectedCycle dc = new DirectedCycle(G);
        if (!dc.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.getReversePost();

        }
    }

    public Topological(EdgeWeightedDigraph G) {
        com.mikalai.algo.graph.shortpath.acyclic.DirectedCycle dc = new com.mikalai.algo.graph.shortpath.acyclic.DirectedCycle(G);
        if (!dc.hasCycle()) {
            com.mikalai.algo.graph.shortpath.acyclic.DepthFirstOrder dfs = new com.mikalai.algo.graph.shortpath.acyclic.DepthFirstOrder(G);
            order = dfs.getReversePost();

        }
    }

    public static void main(String[] args) {
        Digraph g = new Digraph(4);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);

        Topological c = new Topological(g);

        for (Integer n : c.order) {
            System.out.println(n);
        }
    }
}
