package DynamicProgramming;

import java.util.Arrays;

public class KnapSack {
    
}

class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        int n = wt.length;
        
        int[][] dp = new int[n][W + 1];
        
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        
        return helper(n - 1, W, wt, val, dp);
    }
    
    static int helper(int ind, int W, int wt[], int val[], int[][] dp){
        if(ind == 0){
            if(wt[ind] <= W) return val[ind];
            return 0;
        }
        
        if(dp[ind][W] != -1) return dp[ind][W];
        
        int notTake = 0 + helper(ind - 1, W, wt, val, dp);
        int take = Integer.MIN_VALUE;
        
        if(wt[ind] <= W){
            take = val[ind] + helper(ind - 1, W - wt[ind], wt, val, dp);
        }
        
        return dp[ind][W] = Math.max(notTake, take);
    }
}
