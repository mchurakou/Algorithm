package com.mikalai.algo.graph.weighted.mst;


import com.mikalai.algo.graph.weighted.Edge;
import com.mikalai.algo.graph.weighted.EdgeWeightedGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class EagerPrimMST implements MinimailSkeletonTree {
    private boolean[] marked;
    private Queue<Edge> mst;
    private PriorityQueue<Edge> pq;
    private double[] distTo;
    private Edge[] edgeTo;

    public EagerPrimMST(EdgeWeightedGraph G) {
        distTo = new double[G.V()];
        edgeTo = new Edge[G.V()];

        Arrays.fill(distTo, Double.MAX_VALUE);

        pq = new PriorityQueue<>();
        marked = new boolean[G.V()];
        mst = new LinkedList<>();

        visit(G, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w])
                continue;

            mst.add(e);

            if (!marked[v])
                visit(G, v);

            if (!marked[w])
                visit(G, w);
        }

    }

    private void visit(EdgeWeightedGraph g, int v) {
        marked[v] = true;
        for (Edge e : g.adj(v)) {
            int to = e.other(v);
            if (!marked[to]) {
                if (distTo[to] > e.weight()) {
                    distTo[to] = e.weight();
                    Edge prevEdge = edgeTo[to];
                    edgeTo[to] = e;

                    pq.remove(prevEdge);
                    pq.add(e);
                }
            }
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

        MinimailSkeletonTree mst = new EagerPrimMST(graph);
        for (Edge e : mst.edges()) {
            System.out.println(e);
        }

        System.out.println("Total:" + mst.weight());
    }
}
