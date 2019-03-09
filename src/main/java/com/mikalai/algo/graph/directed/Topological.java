package com.mikalai.algo.graph.directed;

/**
 * Created by mikalai on 23.08.2015.
 */
public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph G) {
        DirectedCycle dc = new DirectedCycle(G);
        if (!dc.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
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
