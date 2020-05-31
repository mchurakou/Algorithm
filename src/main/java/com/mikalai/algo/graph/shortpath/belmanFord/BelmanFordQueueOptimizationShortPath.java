package com.mikalai.algo.graph.shortpath.belmanFord;


import com.mikalai.algo.graph.shortpath.DirectedEdge;
import com.mikalai.algo.graph.shortpath.EdgeWeightedDigraph;
import com.mikalai.algo.graph.shortpath.ShortPath;
import com.mikalai.algo.graph.shortpath.acyclic.DirectedCycle;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//works for negative weighted edges without negative cycles
public class BelmanFordQueueOptimizationShortPath extends ShortPath {
    private final Queue<Integer> queue;
    private final boolean[] onQ;
    private int cost;
    private Stack<Integer> cycle;


    public BelmanFordQueueOptimizationShortPath(EdgeWeightedDigraph g, int s) {
        super(g, s);
        queue = new LinkedList<>();
        onQ = new boolean[g.getV()];
        distTo[s] = 0;

        queue.add(s);
        onQ[s] = true;

        while (!queue.isEmpty() && !hasNegativeCycle()
        ) {
            Integer v = queue.poll();
            relax(v);
        }


    }

    private boolean hasNegativeCycle() {
        return cycle != null;
    }

    private void relax(final Integer from) {
        for (DirectedEdge edge : g.adj(from)) {
            if (distTo[edge.getTo()] > distTo[edge.getFrom()] + edge.getWeight()) {
                distTo[edge.getTo()] = distTo[edge.getFrom()] + edge.getWeight();
                edgeTo[edge.getTo()] = edge;

                if (!onQ[edge.getTo()]) {
                   queue.add(edge.getTo());
                    onQ[edge.getTo()] = true;
                }
            }
        }

        if (cost++ % g.getV() == 0) {
            findNegativeCycle();

        }
    }

    private void findNegativeCycle() {
        EdgeWeightedDigraph gr = new EdgeWeightedDigraph(g.getV());

        for (int i = 0; i < g.getV(); i++) {
            if (edgeTo[i] != null) {
                gr.addEdge(edgeTo[i]);
            }
        }
        DirectedCycle directedCycle = new DirectedCycle(gr);
        cycle = directedCycle.cycle();
    }


    public static void main(String[] args) {
        EdgeWeightedDigraph ewd = new EdgeWeightedDigraph(8);
        ewd.addEdge(new DirectedEdge(4, 5, 0.35));
        ewd.addEdge(new DirectedEdge(5, 4, 0.35));
        ewd.addEdge(new DirectedEdge(4, 7, 0.37));
        ewd.addEdge(new DirectedEdge(5, 7, 0.28));
        ewd.addEdge(new DirectedEdge(7, 5, 0.28));
        ewd.addEdge(new DirectedEdge(5, 1, 0.32));
        ewd.addEdge(new DirectedEdge(0, 4, 0.38));
        ewd.addEdge(new DirectedEdge(0, 2, 0.26));
        ewd.addEdge(new DirectedEdge(7, 3, 0.39));
        ewd.addEdge(new DirectedEdge(1, 3, 0.29));
        ewd.addEdge(new DirectedEdge(2, 7, 0.34));
        ewd.addEdge(new DirectedEdge(6, 2, 0.40));
        ewd.addEdge(new DirectedEdge(3, 6, 0.52));
        ewd.addEdge(new DirectedEdge(6, 0, 0.58));
        ewd.addEdge(new DirectedEdge(6, 4, 0.93));

        ShortPath shortPath = new BelmanFordQueueOptimizationShortPath(ewd, 0);

        System.out.println("DIST:" + shortPath.distTo(6));
        if (shortPath.hasPathTo(6)) {
            for (DirectedEdge e : shortPath.pathTo(6)) {
                System.out.println(e + " ");
            }
        }

    }

}
