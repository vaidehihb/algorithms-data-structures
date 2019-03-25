package com.algo.ds.backtracking;

// word serach in 4 directions. Can be extended for 8 by adding more directions in dirs array
public class WordSerachIn2DGrid {
    private int[][] dirs = new int[][]{
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    private boolean dfs(char[][] board, int i, int j, int index, String word){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#') return false;

        if(index >= word.length() || board[i][j] != word.charAt(index)) return false;

        if(index == word.length()-1) return true;

        char temp = board[i][j];
        board[i][j] = '#';
        for(int[] dir:dirs){
            if(dfs(board, i+dir[0], j+dir[1], index+1, word)) return true;
        }
        board[i][j] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) return true;
            }
        }
        return false;
    }
}
