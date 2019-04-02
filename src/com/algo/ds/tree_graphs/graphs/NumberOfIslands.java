package com.algo.ds.tree_graphs.graphs;

public class NumberOfIslands {
    public int numIslands(char[][] grid){
        if(grid == null || grid.length == 0) return 0;
        int islands = 0;
        int r = grid.length;
        int c = grid[0].length;
        for(int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                if(grid[i][j] == '1'){
                    islands++;
                    findNeighbouringOnes(grid, r, c, i, j);
                }
            }
        }
        return islands;
    }

    private void findNeighbouringOnes(char[][] grid, int r, int c, int i, int j){
        if(i<0 || i>=r || j<0 || j>=c || grid[i][j] != '1') return;
        grid[i][j] = '2';
        findNeighbouringOnes(grid, r, c, i+1, j);
        findNeighbouringOnes(grid, r, c, i-1, j);
        findNeighbouringOnes(grid, r, c, i, j+1);
        findNeighbouringOnes(grid, r, c, i, j-1);
    }
}
