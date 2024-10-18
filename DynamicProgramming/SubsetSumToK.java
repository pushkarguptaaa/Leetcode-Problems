package DynamicProgramming;

import java.util.Arrays;

public class SubsetSumToK {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        int[][] dp = new int[n][k + 1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return h(n - 1, k, arr, dp);
    }
    static boolean h(int ind, int k, int[] arr, int[][] dp){
        if(k == 0) return true;
        if(ind == 0) return arr[ind] == k;

        if(dp[ind][k] != -1) return dp[ind][k] == 1;

        boolean notTake = h(ind - 1, k, arr, dp);
        boolean take = false;

        if(k >= arr[ind]){
            take = h(ind - 1, k - arr[ind], arr, dp);
        }

        dp[ind][k] = (take || notTake) ? 1: 0;

        return dp[ind][k] == 1;
    }
}
