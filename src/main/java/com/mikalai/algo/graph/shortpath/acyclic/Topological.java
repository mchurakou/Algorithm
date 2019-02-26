package com.mikalai.algo.graph.shortpath.acyclic;

import com.mikalai.algo.graph.shortpath.EdgeWeightedDigraph;

/**
 * Created by mikalai on 23.08.2015.
 */
public class Topological {
    public Iterable<Integer> order;

    public Topological(EdgeWeightedDigraph G) {
        DirectedCycle dc = new DirectedCycle(G);
        if (!dc.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.getReversePost();

        }
    }

}
