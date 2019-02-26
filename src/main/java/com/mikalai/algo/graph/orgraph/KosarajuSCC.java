package com.mikalai.algo.graph.orgraph;

import com.mikalai.algo.graph.Graph;

import java.util.*;

/**
 * Created by mikalai on 24.08.2015.
 */
public class KosarajuSCC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph d) {
        marked = new boolean[d.V()];
        id = new int[d.V()];
        DepthFirstOrder order = new DepthFirstOrder(d.reverse());
        List<Integer> list = new ArrayList<Integer>();
        order.getReversePost().forEach((el) -> {
            list.add(el);
        });

        Collections.reverse(list);


        for (int s : list) {
            if (!marked[s]) {
                dfs(d, s);
                count++;
            }

        }
    }

    private void dfs(Digraph d, int v) {


        marked[v] = true;
        id[v] = count;

        for (int w : d.adj(v)) {
            if (!marked[w]) {
                dfs(d, w);
            }

        }


    }

    public boolean stringlyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int i) {
        return id[i];

    }


    public int count() {
        return count;
    }


    public static void main(String[] args) {
        Digraph d = new Digraph(13);


        d.addEdge(4, 2);
        d.addEdge(2, 3);
        d.addEdge(3, 2);

        d.addEdge(0, 1);
        d.addEdge(6, 0);
        d.addEdge(2, 0);

        d.addEdge(11, 12);
        d.addEdge(12, 9);
        d.addEdge(9, 10);
        d.addEdge(9, 11);
        d.addEdge(10, 12);
        d.addEdge(11, 4);
        d.addEdge(4, 3);
        d.addEdge(3, 5);
        d.addEdge(0, 5);
        d.addEdge(5, 4);


        d.addEdge(6, 4);
        d.addEdge(6, 9);

        d.addEdge(7, 8);
        d.addEdge(7, 6);

        d.addEdge(8, 7);
        d.addEdge(8, 9);


        KosarajuSCC scc = new KosarajuSCC(d);

        System.out.println(scc.count() + " components");
        Set<Integer>[] components = (Set<Integer>[]) new Set[scc.count()];


        for (int i = 0; i < scc.count(); i++) {
            components[i] = new LinkedHashSet<Integer>();
        }

        for (int i = 0; i < d.V(); i++) {
            components[scc.id(i)].add(i);

        }


        for (int i = 0; i < scc.count(); i++) {
            for (int v : components[i]) {
                System.out.print(v + " ");

            }
            System.out.println();
        }


    }
}