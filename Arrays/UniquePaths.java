package Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        return countPaths(0, 0, m, n);
    }

    public int countPaths(int i, int j, int n, int m){
        if(i==n-1 && j==m-1) return 1;

        if(i>=n || j>=m) return 0;

        else return countPaths(i+1, j, n, m)+countPaths(i, j+1, n, m);
    }
}

class Solution1 {
    public int uniquePaths(int m, int n) {
        int[][] dp= new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j]= -1;
            }
        }

        return countPaths(0,0,m,n,dp);
    }

    public int countPaths(int i, int j, int n, int m, int[][] dp){
        if(i>=n || j>=m) return 0;

        if(i==n-1 && j==m-1) return 1;

        if(dp[i][j]!=-1) return dp[i][j];

        else dp[i][j]= countPaths(i+1,j,n,m,dp)+countPaths(i,j+1,n,m,dp);
        return dp[i][j];
    }
}

class Solution3 {
    public int uniquePaths(int m, int n) {
        int N= m+n-2;
        int R= m-1;
        double res= 1;

        for(int i=1; i<=R; i++){
            res= res*(N-R+i)/i;
        }

        return (int)res;

    }
}
