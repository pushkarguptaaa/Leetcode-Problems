package DynamicProgramming;

import java.util.Arrays;

public class SuperEggDrop {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return h(k, n, dp);
    }

    int h(int k, int n, int[][] dp){
        if(k == 0) return 0;
        if(k == 1) return n;
        if(n == 0) return 0;

        if(dp[k][n] != -1) return dp[k][n];

        int low = 1;
        int high = n;
        int min = Integer.MAX_VALUE;

        while(low <= high){
            int mid = (low + high) / 2;
            int notbr = h(k, mid - 1, dp);
            int br = h(k - 1, n - mid, dp);

            int worst = 1 + Math.max(notbr, br);

            min = Math.min(min, worst);

            if(notbr > br){
                high = mid - 1;
            } else low = mid + 1;
        }

        return dp[k][n] = min;
    }
}
