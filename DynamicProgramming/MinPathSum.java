package DynamicProgramming;

import java.util.Arrays;

public class MinPathSum {
     public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for(int[] row: dp) Arrays.fill(row, -1);

        return h(n - 1, m - 1, grid, dp);
    }

    int h(int i, int j, int[][] grid, int[][] dp){
        if(i == 0 && j == 0) return grid[i][j];
        if(i < 0 || j < 0) return Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];

        int top = h(i - 1, j, grid, dp);
        int left = h(i, j - 1, grid, dp);

        return dp[i][j] = grid[i][j] + Math.min(top, left);
    }
}
