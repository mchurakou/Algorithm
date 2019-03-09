package com.mikalai.algo.graph.shortpath.acyclic;


import com.mikalai.algo.graph.shortpath.DirectedEdge;
import com.mikalai.algo.graph.shortpath.EdgeWeightedDigraph;
import com.mikalai.algo.graph.shortpath.ShortPath;

import java.util.*;

/**
 * Created by mikalai on 12.10.2015.
 */
public class AcyclicShortPath extends ShortPath {

    public AcyclicShortPath(EdgeWeightedDigraph g, int s) {
        super(g, s);

        for (int i = 0; i < g.getV(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0;

        Topological top = new Topological(g);


        List<Integer> list = new ArrayList<>();

        for (int v : top.order) {
            list.add(v);
        }

        Collections.reverse(list);

        for (int v : list) {
            relax(g, v);
        }
    }

    private void relax(EdgeWeightedDigraph g, int v) {
        for (DirectedEdge e : g.adj(v)) {
            int w = e.getTo();
            if (distTo[w] > distTo[v] + e.getWeight()) {
                distTo[w] = distTo[v] + e.getWeight();
                edgeTo[w] = e;
            }

        }

    }

    public static void main(String[] args) {
        EdgeWeightedDigraph ewd = new EdgeWeightedDigraph(8);
        ewd.addEdge(new DirectedEdge(5, 4, 0.35));
        ewd.addEdge(new DirectedEdge(4, 7, 0.37));
        ewd.addEdge(new DirectedEdge(5, 7, 0.28));
        ewd.addEdge(new DirectedEdge(5, 1, 0.32));
        ewd.addEdge(new DirectedEdge(4, 0, 0.38));
        ewd.addEdge(new DirectedEdge(0, 2, 0.26));
        ewd.addEdge(new DirectedEdge(3, 7, 0.39));
        ewd.addEdge(new DirectedEdge(1, 3, 0.29));
        ewd.addEdge(new DirectedEdge(7, 2, 0.34));
        ewd.addEdge(new DirectedEdge(6, 2, 0.40));
        ewd.addEdge(new DirectedEdge(3, 6, 0.52));
        ewd.addEdge(new DirectedEdge(6, 0, 0.58));
        ewd.addEdge(new DirectedEdge(6, 4, 0.93));


        ShortPath shortPath = new AcyclicShortPath(ewd, 5);

        System.out.println("DIST:" + shortPath.distTo(0));
        if (shortPath.hasPathTo(0)) {
            for (DirectedEdge e : shortPath.pathTo(0)) {
                System.out.println(e + " ");
            }
        }

    }


}
