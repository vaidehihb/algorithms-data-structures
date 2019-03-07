package com.algo.ds.tree_graphs.graphs;

import com.algo.ds.data_structures.Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BFS {
    private Graph g;
    private List<Integer> bfsTraversal;

    public BFS(Graph g) {
        this.g = g;
        bfsTraversal = new ArrayList<>();
    }

    public void bfs(int src){
        boolean[] visited = new boolean[g.getV()];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;

        while (queue.size() != 0){
            src = queue.poll();
            bfsTraversal.add(src);
            Iterator<Integer> itr = g.getAdjList()[src].listIterator();
            while (itr.hasNext()){
                int n = itr.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

}
