package com.algo.ds.recursion.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows == 0){
            return res;
        }
        helper(res, numRows, 1, 1);
        return res;
    }

    public static void helper(List<List<Integer>> res, int numRows, int currentRow, int currentCol ){

        if(currentRow > numRows) return;

        if(res.size() < currentRow){
            res.add(new ArrayList<>());
        }

        if(currentCol == 1 || currentCol == currentRow){
            res.get(currentRow-1).add(1);
        }
        else if(currentCol > 1 && currentCol < currentRow){
            res.get(currentRow-1).add(res.get(currentRow-2).get(currentCol - 2) + res.get(currentRow-2).get(currentCol - 1));
        }
        else{
            currentRow++;
            currentCol = 0;
        }

        helper(res, numRows, currentRow, ++currentCol);
    }
}
