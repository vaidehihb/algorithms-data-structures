package com.algo.ds.data_structures;

import java.util.Arrays;

public class YoungTableau {
    public static void youngify(int[][] young_t, int i, int j) {
        int x, y;
        x = i;
        y = j;
        int temp;
        int m = young_t.length;
        int n = young_t[0].length;
        if (i + 1 < m) {
            if (young_t[i][j] > young_t[i + 1][j]) {
                x = i + 1;
                y = j;
            }
        }
        if (j + 1 < n) {
            if (young_t[x][y] > young_t[i][j + 1]) {
                x = i;
                y = j + 1;
            }
        }
        if (x != i || y != j) {
            temp = young_t[x][y];
            young_t[x][y] = young_t[i][j];
            young_t[i][j] = temp;
            youngify(young_t, x, y);
        }
    }


    public static int extract_min(int[][] youngT) {
        int x = youngT[0][0];
        youngT[0][0] = Integer.MAX_VALUE;
        youngify(youngT, 0, 0);
        return x;
    }


    public static void insert_key(int[][] young_t, int i, int j, int key) {
        int x, y, max, temp;
        if (young_t[i][j] < key) {
            System.out.println("No more insertions possible, The tableau is full");
            return;
        }
        young_t[i][j] = key;
        x = i;
        y = j;
        max = Integer.MAX_VALUE;
        while ((i > 0 || j > 0) && (max > young_t[i][j])) {
            temp = young_t[x][y];
            young_t[x][y] = young_t[i][j];
            young_t[i][j] = temp;
            i = x;
            j = y;
            if (i - 1 >= 0 && young_t[i][j] < young_t[i - 1][j]) {
                x = i - 1;
                y = j;
            }
            if (j - 1 >= 0 && young_t[x][y] < young_t[i][j - 1]) {
                x = i;
                y = j - 1;
            }
            max = young_t[x][y];
        }
    }

    public static boolean search_key(int[][] young_t, int i, int j, int key) {
        int start_x, start_y;
        start_x = i;
        start_y = j;
        int m = young_t.length;
        int n = young_t[0].length;
        if (i >= 0 && j < n) {
            if (young_t[i][j] == key) {
                return true;
            } else if (young_t[i][j] < key) {
                return search_key(young_t, i, j + 1, key);
            } else if (young_t[i][j] > key) {
                return search_key(young_t, i - 1, j, key);
            } else return false;
        } else return false;
    }


//    static void sort(int arr[])
//    {
//        int n = arr.length;
//
//        // Build heap (rearrange array)
//        for (int i = n / 2 - 1; i >= 0; i--)
//            youngify(arr, n, i);
//
//        // One by one extract an element from heap
//        for (int i=n-1; i>=0; i--)
//        {
//
//            int temp = arr[0];
//            arr[0] = arr[i];
//            arr[i] = temp;
//
//            // call max heapify on the reduced heap
//            youngify(arr, i, 0);
//        }
//    }

    private static int[][] initializeTableau(int length){
        int n = (int)Math.sqrt(length);
        int m = (n * n == length) ? n : n+1;
        System.out.println(m + ":" + n);
        int[][] tableau = new int[m][n];
        for(int i=0; i<m; i++){
            for (int j = 0; j < n; j++) {
                tableau[i][j] = Integer.MAX_VALUE;
            }
        }
        return tableau;
    }

    public static void main(String args[]) {

        int[] arr = {9, 18, 3, 2, 4, 8, 5, 14, 12};
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[][] tableau = initializeTableau(max);

        for(int i=0;i<arr.length;i++)
        {
            insert_key(tableau, tableau.length-1, tableau[0].length-1,arr[i]);
        }
//
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[0].length; j++) {
                System.out.print(tableau[i][j] + " ");
            }
            System.out.println();
        }
    }
}
