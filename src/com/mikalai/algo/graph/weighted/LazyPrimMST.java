package com.mikalai.algo.graph.weighted;


import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LazyPrimMST {
    private boolean[] marked;
    private Queue<Edge> mst;
    private PriorityQueue<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new PriorityQueue<Edge>();
        marked = new boolean[G.V()];
        mst = new LinkedList<Edge>();

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
            if (!marked[e.other(v)]) {
                pq.add(e);
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

        LazyPrimMST mst = new LazyPrimMST(graph);
        for (Edge e : mst.edges()) {
            System.out.println(e);
        }

        System.out.println("Total:" + mst.weight());
    }
}
