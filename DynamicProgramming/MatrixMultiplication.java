package DynamicProgramming;

import java.util.Arrays;

public class MatrixMultiplication {
    static int matrixMultiplication(int N, int arr[])
    {
        int[][] dp = new int[N][N];
        
        for(int[] row: dp) Arrays.fill(row, -1);
        
        return h(1, N - 1, arr, dp);
    }
    
    static int h(int i, int j, int arr[], int[][] dp){
        if(i == j) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int min = Integer.MAX_VALUE;
        
        for(int k = i; k < j; k++){
            int steps = arr[i - 1] * arr[k] * arr[j] + h(i, k, arr, dp) + h(k + 1, j, arr, dp);
            
            if(steps < min) min = steps;
        }
        
        return dp[i][j] = min;
    }
}
