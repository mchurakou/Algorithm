package com.mikalai.algo.context.flow;

import com.sun.tools.javac.comp.Flow;

import java.util.LinkedList;
import java.util.Queue;

public class MaxFlowFulkersonFord {

    private double value;
    private FlowEdge[] edgeTo;

    public MaxFlowFulkersonFord(final FlowNetwork flowNetwork, final int start, final int finish) {
        while(hasAugmentedPath(flowNetwork, start, finish)) {
            double bottle = Double.POSITIVE_INFINITY;


            //Вычисление минимальной пропускной способности в найденоом пути
            for (int v = finish; v != start ; v = edgeTo[v].other(v)) {
                bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
            }

            //расширение пути
            for (int v = finish; v != start ; v = edgeTo[v].other(v)) {
                edgeTo[v].addResidualFlowTo(v, bottle);
            }
            value += bottle;
        }
    }

    private boolean hasAugmentedPath(final FlowNetwork flowNetwork, final int start, final int finish) {
        boolean[] marked = new boolean[flowNetwork.getVertexCount()];
        edgeTo = new FlowEdge[flowNetwork.getVertexCount()];
        Queue<Integer> queue = new LinkedList<>();

        marked[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            for (FlowEdge flowEdge : flowNetwork.adj(v)) {
                int w = flowEdge.other(v);
                if (!marked[w] && flowEdge.residualCapacityTo(w) > 0) {
                    edgeTo[w] = flowEdge;
                    marked[w] = true;
                    queue.add(w);
                }
            }

        }

        return marked[finish];
    }


    private double value() {
        return value;
    }

    public static void main(String[] args) {
        int vertexCount = 6;
        FlowNetwork flowNetwork = new FlowNetwork(vertexCount);
        flowNetwork.addEdge(new FlowEdge(0, 2,3.0));
        flowNetwork.addEdge(new FlowEdge(0, 1,2.0));
        flowNetwork.addEdge(new FlowEdge(1, 4,1.0));
        flowNetwork.addEdge(new FlowEdge(1, 3,3.0));
        flowNetwork.addEdge(new FlowEdge(2, 3,1.0));
        flowNetwork.addEdge(new FlowEdge(2, 4,1.0));
        flowNetwork.addEdge(new FlowEdge(3, 5,2.0));
        flowNetwork.addEdge(new FlowEdge(4, 5,3.0));

        int start = 0;
        int finish = 5;
        MaxFlowFulkersonFord maxFlow = new MaxFlowFulkersonFord(flowNetwork, start, finish);
        System.out.println("Max flow:" + maxFlow.value());

        for (int i = 0; i < vertexCount; i++) {
            for (FlowEdge flowEdge : flowNetwork.adj(i)) {
                if (flowEdge.getFrom() == i && flowEdge.getFlow() > 0) {
                    System.out.println(flowEdge);
                }
            }


        }
    }
}
