package com.algo.ds.data_structures;
import java.util.LinkedList;

public class Graph{
    private int V;
    private LinkedList<Integer>[] adjList;
    private int[][] adjMatrix;

    public Graph(int v){
        V = v;
        adjList = new LinkedList[v];
        for(int i=0;i<v;i++){
            adjList[i] = new LinkedList<>();
        }
        adjMatrix = new int[v][v];
    }

    public void addEdge(int u, int w){
        adjList[u].add(w);
        adjMatrix[u][w] = 1;
    }

    public void removeEdge(int u, int w){
        adjList[u].remove(w);
        adjMatrix[u][w] = 0;
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public LinkedList<Integer>[] getAdjList() {
        return adjList;
    }

    public void setAdjList(LinkedList<Integer>[] adjList) {
        this.adjList = adjList;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void setAdjMatrix(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }
}
