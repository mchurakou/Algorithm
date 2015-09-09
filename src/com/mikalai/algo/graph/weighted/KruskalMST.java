package com.mikalai.algo.graph.weighted;


import com.mikalai.algo.unionfind.WeightedUnionUF;

import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        Queue<Edge> pq = new PriorityQueue<Edge>((Collection<? extends Edge>) G.edges());
        mst = new LinkedList<Edge>();

        WeightedUnionUF uf = new WeightedUnionUF(G.V());

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.poll();
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) continue;

            uf.union(v, w);
            mst.add(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }


    public double weight() {
        double res = 0;
        for (Edge e : mst) {
            res += e.weight();
        }
        return res;
    }

    public static void main(String[] args) {
        EdgeWeightedGraph graph = new EdgeWeightedGraph(8);
        graph.addEdge(new Edge(4, 5, .35));
        graph.addEdge(new Edge(4, 7, .37));
        graph.addEdge(new Edge(5, 7, .28));
        graph.addEdge(new Edge(0, 7, .16));
        graph.addEdge(new Edge(1, 5, .32));
        graph.addEdge(new Edge(0, 4, .38));
        graph.addEdge(new Edge(2, 3, .17));
        graph.addEdge(new Edge(1, 7, .19));
        graph.addEdge(new Edge(0, 2, .26));
        graph.addEdge(new Edge(1, 2, .36));
        graph.addEdge(new Edge(1, 3, .29));
        graph.addEdge(new Edge(2, 7, .34));
        graph.addEdge(new Edge(6, 2, .40));
        graph.addEdge(new Edge(3, 6, .52));
        graph.addEdge(new Edge(6, 0, .58));
        graph.addEdge(new Edge(6, 4, .93));

        KruskalMST mst = new KruskalMST(graph);
        for (Edge e : mst.edges()) {
            System.out.println(e);
        }

        System.out.println("Total:" + mst.weight());
    }
}

