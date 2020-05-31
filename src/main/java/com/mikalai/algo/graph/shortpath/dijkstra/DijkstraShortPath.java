package com.mikalai.algo.graph.shortpath.dijkstra;



import com.mikalai.algo.graph.shortpath.DirectedEdge;
import com.mikalai.algo.graph.shortpath.EdgeWeightedDigraph;
import com.mikalai.algo.graph.shortpath.ShortPath;

import java.util.Map;
import java.util.PriorityQueue;
//works for none negative weighted edges
public class DijkstraShortPath extends ShortPath {

    private final PriorityQueue<Map.Entry<Integer, Double>> pq;

    public DijkstraShortPath(EdgeWeightedDigraph g, int s) {
        super(g, s);
        distTo[s] = 0;

        pq = new PriorityQueue<>(Map.Entry.comparingByValue());

        pq.add(Map.entry(s, distTo[s]));

        while (!pq.isEmpty()) {
             relax(pq.poll().getKey());
        }

    }

    private void relax(final Integer from) {
        for (DirectedEdge edge : g.adj(from)) {
            if (distTo[edge.getTo()] > distTo[edge.getFrom()] + edge.getWeight()) {
                distTo[edge.getTo()] = distTo[edge.getFrom()] + edge.getWeight();
                edgeTo[edge.getTo()] = edge;

                Map.Entry<Integer, Double> entry = Map.entry(edge.getTo(), edge.getWeight());

                pq.removeIf(e -> e.getKey() ==  edge.getTo());
                pq.add(entry);
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
