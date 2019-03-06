package com.mikalai.algo.graph.undirected;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by mikalai on 13.07.2015.
 */
public class CohesiveComponent {
    private boolean[] marked;
    private int[] componentId;
    private int count;

    public CohesiveComponent(Graph g) {
        marked = new boolean[g.getVertexCount()];
        componentId = new int[g.getVertexCount()];
        for (int s = 0; s < g.getVertexCount(); s++) {
            if (!marked[s]) {
                dfs(g, s);
                count++;
            }

        }

    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        componentId[v] = count;
        for (int w : g.adjacentVertexes(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }

        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int v, int w) {
        return componentId[v] == componentId[w];
    }

    public int componentId(int i) {
        return componentId[i];

    }

    public static void main(String[] args) {
        Graph g = new Graph(13);

        g.addEdge(0, 6);
        g.addEdge(0, 2);
        g.addEdge(0, 1);
        g.addEdge(0, 5);
        g.addEdge(0, 6);
        g.addEdge(3, 5);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(7, 8);
        g.addEdge(9, 11);
        g.addEdge(9, 10);
        g.addEdge(9, 12);
        g.addEdge(11, 12);

        CohesiveComponent cc = new CohesiveComponent(g);

        System.out.println(cc.count() + " components");
        Set<Integer>[] components = (Set<Integer>[]) new Set[cc.count()];


        for (int i = 0; i < cc.count(); i++) {
            components[i] = new LinkedHashSet<Integer>();
        }

        for (int i = 0; i < g.getVertexCount(); i++) {
            components[cc.componentId(i)].add(i);

        }


        for (int i = 0; i < cc.count(); i++) {
            for (int v : components[i]) {
                System.out.print(v + " ");

            }
            System.out.println();
        }


    }
}
