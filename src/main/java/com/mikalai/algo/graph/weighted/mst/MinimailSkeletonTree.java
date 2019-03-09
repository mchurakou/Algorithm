package com.mikalai.algo.graph.weighted.mst;

import com.mikalai.algo.graph.weighted.Edge;

public interface MinimailSkeletonTree {
    Iterable<Edge> edges();

    double weight();
}
