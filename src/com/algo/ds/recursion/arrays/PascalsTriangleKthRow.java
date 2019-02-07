package com.algo.ds.recursion.arrays;

import java.util.ArrayList;
import java.util.List;

// with O(k) extra space, 1-indexed rows
public class PascalsTriangleKthRow {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if(rowIndex < 0) return result;
        helper(result, rowIndex, 1, 1);
        return result;
    }

    public static void helper(List<Integer> result, int rowIndex, int currentCol, int currentRow){
        if(currentRow > rowIndex) return;

        if(result.size() < currentRow){
            result.add(1);
        }

        if(currentCol == 1 || currentCol == currentRow){
            result.set(currentCol-1, 1);
        }
        else if(currentCol > 1 && currentCol < currentRow){
            result.set(currentCol-1, result.get(currentCol-2) + result.get(currentCol-1));
        }
        else{
            currentRow++;
            currentCol = currentRow;
        }
        helper(result, rowIndex, --currentCol, currentRow);
    }
}
