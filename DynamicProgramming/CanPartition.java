package DynamicProgramming;

import java.util.Arrays;

public class CanPartition {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int tsum = 0;

        for(int i: nums) tsum+= i;

        if(tsum % 2 == 1) return false;

        int sum = tsum / 2;

        return subsetSumToK(n, sum, nums);
    }

    boolean subsetSumToK(int n, int k, int arr[]){
        int[][] dp = new int[n][k + 1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return h(n - 1, k, arr, dp);
    }
    boolean h(int ind, int k, int[] arr, int[][] dp){
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
