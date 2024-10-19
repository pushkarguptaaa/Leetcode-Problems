package DynamicProgramming;

import java.util.Arrays;

public class MinCost {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] arr = new int[c + 2];
        arr[0] = 0;
        arr[c + 1] = n;

        for(int i = 0; i < c; i++) arr[i + 1] = cuts[i];

        Arrays.sort(arr);

        int[][] dp = new int[c + 1][c + 1];

        for(int[] row: dp) Arrays.fill(row, -1);

        return h(1, c, arr, dp); 
    }

    int h(int i, int j, int[] arr, int[][] dp){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;

        for(int ind = i; ind <= j; ind++){
            int cost = arr[j + 1] - arr[i - 1] + h(i, ind - 1, arr, dp) + h(ind + 1, j, arr, dp);
            min = Math.min(min, cost);
        }

        return dp[i][j] = min;
    }
}
