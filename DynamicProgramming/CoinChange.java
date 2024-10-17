package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for(int[] row: dp) Arrays.fill(row, -1);

        int ans = h(n - 1, coins, amount, dp);

        if(ans >= (int)1e9) return -1;
        return ans;
    }

    int h(int ind, int[] coins, int T, int[][] dp){
        if(ind == 0){
            if(T % coins[ind] == 0) return T / coins[ind];
            return (int)1e9;
        }

        if(dp[ind][T] != -1) return dp[ind][T];

        int notTake = 0 + h(ind - 1, coins, T, dp);
        int take = Integer.MAX_VALUE;

        if(coins[ind] <= T){
            take = 1 + h(ind, coins, T - coins[ind], dp);
        }

        return dp[ind][T] = Math.min(notTake, take);
    }
}
