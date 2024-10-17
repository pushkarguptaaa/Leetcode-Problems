package DynamicProgramming;

import java.util.Arrays;

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for(int[] row: dp) Arrays.fill(row, -1);

        return h(n - 1, amount, coins, dp);
    }

    int h(int ind, int T, int[] coins, int[][] dp){
        if(ind == 0){
            return (T % coins[ind] == 0) ? 1: 0;
        }

        if(dp[ind][T] != -1) return dp[ind][T];

        int notTake = h(ind - 1, T, coins, dp);
        int take = 0;

        if(T >= coins[ind]){
            take = h(ind, T - coins[ind], coins, dp);
        }

        return dp[ind][T] = notTake + take;
    }
}
