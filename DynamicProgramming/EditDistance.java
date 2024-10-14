package DynamicProgramming;

import java.util.Arrays;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];

        for(int[] row: dp) Arrays.fill(row, -1);

        return h(n - 1, m - 1, word1, word2, dp);
    }

    int h(int i, int j, String word1, String word2, int[][] dp){
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)) return dp[i][j] = h(i - 1, j - 1, word1, word2, dp);

        return dp[i][j] = 1 + Math.min(h(i - 1, j, word1, word2, dp), Math.min(h(i, j - 1, word1, word2, dp), h(i - 1, j - 1, word1, word2, dp)));
    }
}
