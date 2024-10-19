package DynamicProgramming;

import java.util.Arrays;

public class CutRod {
    public int cutRod(int price[], int n) {
        int[][] dp = new int[n][n + 1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return h(n - 1, n, price, dp);
    }
    
    int h(int ind, int N, int[] arr, int[][] dp){
        if(ind == 0) return N * arr[ind];

        if(dp[ind][N] != -1) return dp[ind][N];

        int notTake = 0 + h(ind - 1, N, arr, dp);
        int rodlen = ind + 1;
        int take = Integer.MIN_VALUE;
        if(N >= rodlen) take = arr[ind] + h(ind, N - rodlen, arr, dp);

        return dp[ind][N] = Math.max(notTake, take);
    }
}
