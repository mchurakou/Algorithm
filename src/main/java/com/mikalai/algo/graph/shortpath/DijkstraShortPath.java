package com.mikalai.algo.graph.shortpath;


import com.mikalai.algo.collections.queue.IndexMinPQ;

public class DijkstraShortPath extends ShortPath {

    private IndexMinPQ<Double> pq;

    public DijkstraShortPath(EdgeWeightedDigraph g, int s) {
        super(g, s);
        pq = new IndexMinPQ<>(g.getV());

        for (int i = 0; i < g.getV(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0;

        pq.insert(s, 0.0);

        while (!pq.isEmpty()) {
            relax(g, pq.delMin());
        }
    }

    private void relax(EdgeWeightedDigraph g, int v) {
        for (DirectedEdge e : g.adj(v)) {
            int w = e.getTo();
            if (distTo[w] > distTo[v] + e.getWeight()) {
                distTo[w] = distTo[v] + e.getWeight();
                edgeTo[w] = e;

                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }

        }

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

        ShortPath shortPath = new DijkstraShortPath(ewd, 0);

        System.out.println("DIST:" + shortPath.distTo(6));
        if (shortPath.hasPathTo(6)) {
            for (DirectedEdge e : shortPath.pathTo(6)) {
                System.out.println(e + " ");
            }
        }

    }

}
