package com.algo.ds.tree_graphs.graphs;
import com.algo.ds.data_structures.Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DFS {
    private Graph g;
    private List<Integer> dfsTraversal;

    public DFS(Graph g) {
        this.g = g;
        dfsTraversal = new ArrayList<>();
    }

    public void dfs(int src){

        boolean[] visited = new boolean[g.getV()];
        dfsHelper(src, visited);
    }

    private void dfsHelper(int v, boolean[] visited){
        visited[v] = true;
        dfsTraversal.add(v);
        Iterator<Integer> itr = g.getAdjList()[v].listIterator();
        while (itr.hasNext()){
            int n = itr.next();
            if(!visited[n]) dfsHelper(n, visited);
        }
    }

}
